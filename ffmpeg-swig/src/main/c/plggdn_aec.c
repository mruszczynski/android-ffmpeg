#include "plggdn_aec.h"

#include <stdlib.h>
#include <memory.h>

plggdn_aec_t *plggdn_aec_create(plggdn_aec_vtable *implementation, plggdn_aec_base_attr *arg) {
    plggdn_aec_t *obj = malloc(sizeof(plggdn_aec_t));

    if(!arg)
        return NULL;
    
    *_plggdn_aec_base(obj) = *arg;
    
    if(!implementation)
        return NULL;
    
    _plggdn_aec_vt(obj) = implementation;
    
    plggdn_aec_init(obj, arg);
    
    return obj;    
}
int plggdn_aec_release(plggdn_aec_t **aec) {
    plggdn_aec_free(*aec);
    
    free(*aec);
    *aec = NULL;
    return 0;
}



int plggdn_aec_init(plggdn_aec_t *aec, void *arg) {
    return _plggdn_aec_vt(aec)->init(aec, arg);
}
int plggdn_aec_free(plggdn_aec_t *aec) {
    return _plggdn_aec_vt(aec)->free(aec);
}

// synced cancellation
int plggdn_aec_echo_cancel(plggdn_aec_t *aec, void *input, void *echo, void *out) {
    return _plggdn_aec_vt(aec)->echo_cancel(aec, input, echo, out);
}

// async cancellation
int plggdn_aec_echo_playback(plggdn_aec_t *aec, void *echo) {
    return _plggdn_aec_vt(aec)->echo_playback(aec, echo);
}
int plggdn_aec_echo_capture(plggdn_aec_t *aec, void *input, void *out) {
    return _plggdn_aec_vt(aec)->echo_capture(aec, input, out);
}
