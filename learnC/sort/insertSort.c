#include <stdio.h>
#include <stdlib.h>

void print(int*,int);

int main(){
  int a[] = {0,2,1,4,3,9,6,5,8,7};
  int n = sizeof(a) / sizeof(int);
  int key;
  for(int i=1;i<n;++i){
    key = a[i];
    int j;
    for(j=i-1;j>=0 && key <a[j];--j){
	a[j+1]=a[j];
    }
    a[j+1]=key;
  }
  print(a,n);
  return 0;
}
void print(int *a,int n){
  for(int i = 0;i<n-1;++i){
    printf("%d ,",a[i]);
  }
  printf("%d\n",a[n-1]);
}
