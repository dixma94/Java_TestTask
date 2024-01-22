Утилита фильтрации содержимого файлов. 
========================
Фильтрует заданные при запуске файлы, которые содержат целые числа, строки и вещественные числа.

Опции:
-------------------------
* -a  Добавить отфильтрованные данные в уже существующии файлы.
* -p  Задать префикс имен выходных файлов. После данной опции необходимо указать префикс.
* -o  Задать путь для выходных файлов. После данной опции необходимо указать относительный/абсолютный путь.
* -s  Вывести краткую статистику. Выводит количество отфильтрованных данных для каждого типа.
* -f  Вывести полную статистику. Выводит максимальное, минимальное и среднее значение для отфильтрованных вещественных и целых чисел, а также их количество. Для строк выводит количество, максимальную и минимальную длину.

Для запуска утилиты в терминале ввести:
-------------------------
1. java -jar
2. Затем после пробела ввести путь к утилите.
3. Затем после пробела ввести необходимые опции и пути к входным файлам через пробел.
#### Например:
PS C:\Users\DIvanov\Desktop> java -jar Filter_Utility.jar in1.txt in2.txt -p sample -a -f
