################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/main/c/ffmpeg_wrap.c 

OBJS += \
./src/main/c/ffmpeg_wrap.o 

C_DEPS += \
./src/main/c/ffmpeg_wrap.d 


# Each subdirectory must supply rules for building sources it contributes
src/main/c/%.o: ../src/main/c/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -I/home/andrew/pluggedin/android-ffmpeg/ffmpeg -I/usr/lib/jvm/java-6-openjdk/include -I/usr/include -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


