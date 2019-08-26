#include <stdio.h>
#include <stdlib.h>
// union
int main(){//共用体<=>联合体
  union A{
    int a;
    int b;
    int c;
  };
  union A a;
  a.a = 1;
  a.b = 2;
  a.c = 3;
  printf("a.a = %d\n",a.a);
  printf("a.b = %d\n",a.b);
  printf("a.c = %d\n",a.c);
  return 0;
}
