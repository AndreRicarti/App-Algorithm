//
// Created by a.ricarti on 09/12/2016.
//

#include <stdio.h>
#include <jni.h>
#include <time.h>

float timedifference_msec(struct timeval t0, struct timeval t1)
{
    return (t1.tv_sec - t0.tv_sec) * 1000.0f + (t1.tv_usec - t0.tv_usec) / 1000.0f;
}

void BubbleSort(int vet[], int tamanho) {
    if (tamanho == 0) {
        return;
    }

    int i = 0;

    for (i = 0; i < tamanho - 1; i++) {
        if (vet[i + 1] < vet[i]) {
            int aux = vet[i+1];
            vet[i + 1] = vet[i];
            vet[i] = aux;
        }
    }

    /*for(i=0;i<1000000000; i++){

    }*/

    return BubbleSort(vet, tamanho - 1);
}

JNIEXPORT jint JNICALL
Java_com_br_algorithm_MainActivity_BubbleSort(JNIEnv *env, jobject instance, jintArray vet_,
                                              jint tamanho) {
    clock_t t1, t2;

    t1 = clock();

    jint *vet = (*env)->GetIntArrayElements(env, vet_, NULL);

    BubbleSort(vet, tamanho);

    t2 = clock();

    float diff = (((float)(t2 - t1) / 1000000.0F ) * 1000) / 1000;

    (*env)->ReleaseIntArrayElements(env, vet_, vet, 0);

    return diff;
}

