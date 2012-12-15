/* 
 * File:   plggdn_aec_base.h
 * Author: michu
 *
 * Created on 13 grudzień 2012, 15:26
 */

#ifndef PLGGDN_AEC_BASE_H
#define	PLGGDN_AEC_BASE_H

#ifdef	__cplusplus
extern "C" {
#endif

    typedef struct plggdn_aec_t plggdn_aec_t;
    
    typedef struct plggdn_aec_vtable {
        int (*init)(plggdn_aec_t *ptr, void *arg);
        int (*free)(plggdn_aec_t *aec);

        // synced cancellation
        int (*echo_cancel)(plggdn_aec_t *aec, void *input, void *echo, void *out);

        // async cancellation
        int (*echo_playback)(plggdn_aec_t *aec, void *echo);
        int (*echo_capture)(plggdn_aec_t *aec, void *input, void *out);
    } plggdn_aec_vtable;
    
    
    typedef struct plggdn_aec_base_attr {
        int frame_size;
        int filter_length;
    } plggdn_aec_base_attr;
    
    typedef struct plggdn_aec_base_t {
        union {
            plggdn_aec_base_attr plggdn;
        } base;
        
        #define _plggdn_aec_base(ptr) (&(ptr)->base.plggdn)
    } plggdn_aec_base_t;
    
    typedef struct plggdn_aec_attr {
        union {
            plggdn_aec_base_t plggdn;
        } base;
        // other stuff here
                
        // implementation data
        void *priv;
        // implementation vtable
        plggdn_aec_vtable *vtable;
        
    } plggdn_aec_attr;
    
    struct plggdn_aec_t {
        union {
            plggdn_aec_attr aec;
            plggdn_aec_base_attr plggdn;
        } base;

        #define _plggdn_aec(self) (&(self)->base.aec)
        #define _plggdn_aec_vt(self) (_plggdn_aec(self)->vtable)        
    };
    
    
    // public interface
    plggdn_aec_t *plggdn_aec_create(plggdn_aec_vtable *implementation, plggdn_aec_base_attr *arg);
    int plggdn_aec_release(plggdn_aec_t **aec);
    
    int plggdn_aec_init(plggdn_aec_t *aec, void *arg);
    int plggdn_aec_free(plggdn_aec_t *aec);
    
    // synced cancellation
    int plggdn_aec_echo_cancel(plggdn_aec_t *aec, void *input, void *echo, void *out);
    
    // async cancellation
    int plggdn_aec_echo_playback(plggdn_aec_t *aec, void *echo);
    int plggdn_aec_echo_capture(plggdn_aec_t *aec, void *input, void *out);


#ifdef	__cplusplus
}
#endif

#endif	/* PLGGDN_AEC_BASE_H */

