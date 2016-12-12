//
// Created by a.ricarti on 28/11/2016.
//

int InsertionSort(int vet[], int tamanho)
{
    if (tamanho <= 1){
        return tamanho;
    }

    tamanho = InsertionSort(vet, (tamanho - 1));

    int aux = vet[tamanho];

    int i = tamanho -1;

    while ((i >= 0) && (vet[i] > aux)){
        vet[i+1] = vet[i];
        i--;
    }

    vet[i+1] = aux;
    return tamanho + 1;
}