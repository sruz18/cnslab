#include <stdio.h>
#include <string.h>

int main()
{
    char *text = "Hello World";
    char result[12];
    int i, size;

    size = strlen(text);

    for(i = 0; i < size; i++)
    {
        result[i] = text[i] ^ 0;
        printf("%c", result[i]);
    }

    printf("\n");
    return 0;
}