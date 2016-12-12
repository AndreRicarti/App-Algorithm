//
// Created by a.ricarti on 09/12/2016.
//

#include <stdio.h>
#include <jni.h>

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

    return BubbleSort(vet, tamanho - 1);
}

JNIEXPORT jint JNICALL
Java_com_br_algorithm_MainActivity_BubbleSort(JNIEnv *env, jobject instance, jintArray vet_,
                                              jint tamanho) {
    jint *vet = (*env)->GetIntArrayElements(env, vet_, NULL);

    BubbleSort(vet, tamanho);

    (*env)->ReleaseIntArrayElements(env, vet_, vet, 0);

    return vet;
}

