#include <stdio.h>
#include <stdlib.h>

int main(){
  int a,b;
  printf("请用一个特殊符号隔开(如:a,/,',+···)\n");
  scanf("%d%*c%d",&a,&b);
  printf("a=%d,b=%d\n",a,b);
  return 0;
}
