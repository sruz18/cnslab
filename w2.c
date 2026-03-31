#include <stdio.h>
#include <string.h>

int main()
{
    char text[] = "Hello World";
    char andResult[12];
    char xorResult[12];
    int i, size;

    size = strlen(text);

    for(i = 0; i < size; i++)
    {
        andResult[i] = text[i] & 127;
        printf("%c", andResult[i]);
    }

    printf("\n");

    for(i = 0; i < size; i++)
    {
        xorResult[i] = text[i] ^ 127;
        printf("%c", xorResult[i]);
    }

    printf("\n");

    return 0;
}