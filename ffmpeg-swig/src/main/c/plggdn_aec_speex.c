#include <speex/speex_config_types.h>
#include <stdlib.h>
#include "plggdn_aec_speex.h"

plggdn_aec_vtable plggdn_aec_speex_vt = {
   .init = &plggdn_aec_speex_init,
   .free = &plggdn_aec_speex_free,
   .echo_cancel = &plggdn_aec_speex_echo_cancel,
   .echo_playback = &plggdn_aec_speex_echo_playback,
   .echo_capture = &plggdn_aec_speex_echo_capture
};

int plggdn_aec_speex_init(plggdn_aec_t *aec_spx, void *arg) {
    plggdn_aec_speex_attr *spx = malloc(sizeof(plggdn_aec_speex_attr));
    
    spx->spx_echo_state = speex_echo_state_init(
                _plggdn_aec_base(aec_spx)->frame_size, 
                _plggdn_aec_base(aec_spx)->filter_length);
    
    _plggdn_aec(aec_spx)->priv = spx;
    
    return 0;
}

int plggdn_aec_speex_free(plggdn_aec_t* aec_spx) {
    plggdn_aec_speex_attr *spx = (plggdn_aec_speex_attr *) _plggdn_aec(aec_spx)->priv;
    speex_echo_state_destroy(spx->spx_echo_state);
    return 0;
}

// synced cancellation
int plggdn_aec_speex_echo_cancel(plggdn_aec_t *aec_spx, void *input, void *echo, void *out) {
    plggdn_aec_speex_attr *spx = (plggdn_aec_speex_attr *) _plggdn_aec(aec_spx)->priv;
    speex_echo_cancellation(spx->spx_echo_state, input, echo, out);
    return 0;
}

// async cancellation
int plggdn_aec_speex_echo_playback(plggdn_aec_t *aec_spx, void *echo) {
    plggdn_aec_speex_attr *spx = (plggdn_aec_speex_attr *) _plggdn_aec(aec_spx)->priv;
    speex_echo_playback(spx->spx_echo_state, echo);
    return 0;
}
int plggdn_aec_speex_echo_capture(plggdn_aec_t *aec_spx, void *input, void *out) {
    plggdn_aec_speex_attr *spx = (plggdn_aec_speex_attr *) _plggdn_aec(aec_spx)->priv;
    speex_echo_capture(spx->spx_echo_state, input, out);
    return 0;
}