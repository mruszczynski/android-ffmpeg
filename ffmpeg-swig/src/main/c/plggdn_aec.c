#include "plggdn_aec.h"

#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

plggdn_aec_t *plggdn_aec_create(plggdn_aec_attr *arg) {
    if(!arg)
        return NULL;
    
    plggdn_aec_t *aec = malloc(sizeof(plggdn_aec_t));
    memset(aec, 0, sizeof(plggdn_aec_t));
        
    int err = plggdn_aec_init(aec, arg);
    if(err != 0) {
        printf("plggdn_aec_init error: %i\n", err);
        plggdn_aec_release(&aec);
    }
    
    return aec;    
}
int plggdn_aec_release(plggdn_aec_t **aec) {
    plggdn_aec_free(*aec);
    
    free(*aec);
    *aec = NULL;
    return 0;
}


int plggdn_aec_init(plggdn_aec_t *aec, plggdn_aec_attr *arg) {
    
    aec->frame_size = arg->frame_size;
    aec->filter_length = arg->filter_length;
    aec->sample_rate = arg->sample_rate;
    
    aec->vtable = arg->impl;;
    
    int err = aec->vtable->init(aec, arg->opaque);
    if(err != 0) {
        free(aec);
        aec = NULL;
    }
    
    return aec->vtable->init(aec, arg);
}
int plggdn_aec_free(plggdn_aec_t *aec) {
    return aec->vtable->free(aec);
}

// synced cancellation
int plggdn_aec_echo_cancel(plggdn_aec_t *aec, void *input, void *echo, void *out) {
    return aec->vtable->echo_cancel(aec, input, echo, out);
}

// async cancellation
int plggdn_aec_echo_playback(plggdn_aec_t *aec, void *echo) {
    return aec->vtable->echo_playback(aec, echo);
}
int plggdn_aec_echo_capture(plggdn_aec_t *aec, void *input, void *out) {
    return aec->vtable->echo_capture(aec, input, out);
}
