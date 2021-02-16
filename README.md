# NAI-Huffman-algorithm
Implementation of Huffman algorithm


NODE TREE
Mój algorytm huffmana został zaimplementowany na zasadzie budowy kopca składającego się z węzłów. Każda z liter z ciągu podanego w argumentach programu jest przypisywana do odpowiedniego węzła. Każdy z węzłów przechowuje kodowany znak oraz częstość wystąpień. Metoda PrintLeaves wypisuje nasze węzły w kolejności, jeśli rodzic posiada lewe dziecko to do ścieżki liścia dodaje 0 jeśli natomiast posiada prawe to dodaje 1.
MY HEAP
Następnie w klasie MyHeap tworzymy tablicę naszych węzłów, na podstawie której będziemy mogli je uporządkować zgodnie z algorytmem Huffmana. 
Metoda parent zwraca nam węzeł rodzica, natomiast leftChild lewy liść, rightChild prawy liść. 
Metoda IsLeaf sprawdza nam czy już dany węzeł jest już liściem.
Metoda swap zamienia miejscami dwa węzły w naszym kopcu
Metoda recurency sprawdza czy nasz węzeł nie jest liściem lub czymś więcej niż któryś z jego liści. Trzeci if zamienia nam węzeł z lewym liściem i rekurencyjnie wywołuje nam metodę na lewym liściu. Else zamienia nam węzeł z prawym liściem i rekurencyjnie wywołuje nam metodę na prawym liściu.
Metoda insert dodaje nam nasz węzeł do naszego kopca, zwiększając przy tym rozmiar naszego kopca.  Jeśli wartość obecnie dodawanego węzła jest mniejsza niż obecnego dotąd węzła rodzica to następuje zamiana i większy z nich staje się rodzicem.
Metoda delMin usuwa nam najmniejszy element kopca zachowując przy tym strukutre drzewa doskonałego jeśli dobrze pamiętam. Ponownie jest wywoływana metoda recurency żeby utrzymać porządek w naszej kolejce priorytetowej.
MAIN
W pierwszym forze zczytujemy z argumentow programu, jeśli taki char się tam już znajduje to zwiększamy jego licznośc o jeden, jeśli nie to dodajemy do mapy z czestoscia 1. Następnie tworzymy nasz wcześniej zaimplementowany kopiec do którego dodajemy nasze wartości z mapy.
W pętli while która wykonuje się dla większej liczby elementow niż dwa tworzymy poddrzewa, następnie tworzony jest rodzic który przyjmuje znaki i wartości obu swoich dzieci. Następnie dodaje do naszej kolejki priorytetowej naszego rodzica.
Jeśli nasza kolejka priorytetowa ma dlugosc jeden  oznacza to że mamy już odpowiednio zbudowane drzewo i możemy wypisac binarne wartości naszych liter
