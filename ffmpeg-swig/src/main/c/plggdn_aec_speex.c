#include "plggdn_aec_speex.h"

#include <stdlib.h>
#include <stdio.h>
#include <memory.h>

plggdn_aec_vtable plggdn_aec_speex_vt = {
   //.create = &plggdn_aec_speex_create,
   .init = &plggdn_aec_speex_init,
   .free = &plggdn_aec_speex_free,
   //.release = &plggdn_aec_speex_release,
   
   .echo_cancel = &plggdn_aec_speex_echo_cancel,
   .echo_playback = &plggdn_aec_speex_echo_playback,
   .echo_capture = &plggdn_aec_speex_echo_capture
};

//int plggdn_aec_speex_create(plggdn_aec_t **aec_spx, plggdn_aec_attr *arg) {
//    *aec_spx = malloc(sizeof(plggdn_aec_speex_t));
//    
//    int err = plggdn_aec_speex_init(*aec_spx, arg);
//    if(err != 0) {
//        plggdn_aec_speex_release(aec_spx);
//    }
//    
//    _plggdn_aec_vt(*aec_spx) = &plggdn_aec_speex_vt;
//    return err;
//}

int plggdn_aec_speex_init(plggdn_aec_t *spx, void *opaque) {
    int err = 0;
    plggdn_aec_speex_attr *attr = malloc(sizeof(plggdn_aec_speex_attr));
    memset(attr, 0, sizeof(plggdn_aec_speex_attr));
    
    spx->priv = attr;
    
    attr->echo_state = speex_echo_state_init(
                spx->frame_size, 
                spx->filter_length);
    
    if(!attr->echo_state) {
        err = 1;
        plggdn_aec_speex_free(spx);
        goto exception;
    }
    
    err = speex_echo_ctl(attr->echo_state, SPEEX_ECHO_SET_SAMPLING_RATE, (void*)&spx->sample_rate);
    if(err != 0) {
        plggdn_aec_speex_free(spx);
        goto exception;
    }    
    
    exception:
    return err;
}

int plggdn_aec_speex_free(plggdn_aec_t* spx) {
    plggdn_aec_speex_attr *attr = spx->priv;
    if(attr) {
        if(attr->echo_state != NULL)
            speex_echo_state_destroy(attr->echo_state);
        free(spx->priv);
        spx->priv = NULL;
    }
    
    return 0;
}

//int plggdn_aec_speex_release(plggdn_aec_t** spx) {
//    if(*spx) {
//        plggdn_aec_speex_free(*spx);
//        free(*spx);
//        spx = NULL;
//    }
//    return 0;
//}

// synced cancellation
int plggdn_aec_speex_echo_cancel(plggdn_aec_t *spx, void *input, void *echo, void *out) {
    plggdn_aec_speex_attr *attr = spx->priv;
    speex_echo_cancellation(attr->echo_state, input, echo, out);
    return (int) 0;
}

// async cancellation
int plggdn_aec_speex_echo_playback(plggdn_aec_t *spx, void *echo) {
    plggdn_aec_speex_attr *attr = spx->priv;
    speex_echo_playback(attr->echo_state, echo);
    return (int) 0;
}
int plggdn_aec_speex_echo_capture(plggdn_aec_t *spx, void *input, void *out) {
    plggdn_aec_speex_attr *attr = spx->priv;
    speex_echo_capture(attr->echo_state, input, out);
    return (int) 0;
}