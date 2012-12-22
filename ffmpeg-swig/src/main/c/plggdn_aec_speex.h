/* 
 * File:   plggdn_aec_speex.h
 * Author: michu
 *
 * Created on 13 grudzień 2012, 15:22
 */

#ifndef PLGGDN_AEC_SPEEX_H
#define	PLGGDN_AEC_SPEEX_H

#include <speex/speex_echo.h>
#include "plggdn_aec.h"

#ifdef	__cplusplus
extern "C" {
#endif
    
//    typedef struct plggdn_aec_speex_attr {
//        SpeexEchoState *spx_echo_state;        
//    } plggdn_aec_speex_attr;
    
    typedef struct plggdn_aec_speex_attr {
        SpeexEchoState *echo_state;
    } plggdn_aec_speex_attr;
    
//    typedef struct plggdn_aec_speex_t {
//        union {
//            plggdn_aec_speex_attr speex;
//            plggdn_aec_attr aec;
//        } base;
//        
//        // implementation data
//        void *priv;
//        // implementation vtable
//        plggdn_aec_vtable *vtable;
//
//        #define _plggdn_aec_speex(self) (&(self)->base.speex)
//    } plggdn_aec_speex_t;
    
    int plggdn_aec_speex_create(plggdn_aec_t **aec_spx, plggdn_aec_attr *arg);
    int plggdn_aec_speex_init(plggdn_aec_t *aec_spx, void *opaque);
    int plggdn_aec_speex_free(plggdn_aec_t *aec_spx);
    int plggdn_aec_speex_release(plggdn_aec_t **aec_spx);
    
    // synced cancellation
    int plggdn_aec_speex_echo_cancel(plggdn_aec_t *aec_spx, void *input, void *echo, void *out);
    
    // async cancellation
    int plggdn_aec_speex_echo_playback(plggdn_aec_t *aec_spx, void *echo);
    int plggdn_aec_speex_echo_capture(plggdn_aec_t *aec_spx, void *input, void *out);

    extern plggdn_aec_vtable plggdn_aec_speex_vt;

#ifdef	__cplusplus
}
#endif

#endif	/* PLGGDN_AEC_SPEEX_H */

