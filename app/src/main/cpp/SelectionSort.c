//
// Created by Son182 on 11/12/2016.
//
void selectionSort(int array[], int indice){
    if ( indice >= 2 ){
        return;
    }

    int minIndex = indice;

    int index = 0;

    for (index = indice + 1; index < 3; index++ ){
        if (array[index] < array[minIndex]){
            minIndex = index;
        }
    }

    int temp = array[indice];
    array[indice] = array[minIndex];
    array[minIndex] = temp;

    selectionSort(array, indice + 1);
}

