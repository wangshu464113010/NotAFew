#include <stdio.h>
#include <stdlib.h>
#include "mysql.h"

int main(){
  MYSQL *conn_ptr;  
  
  conn_ptr=mysql_init(NULL);  
  if(!conn_ptr){  
    fprintf(stderr,"mysql_init failed \n");  
    return  EXIT_FAILURE;  
  }  
  
  conn_ptr  = mysql_real_connect(conn_ptr,"127.0.0.1","root",NULL,"a",0,NULL,0);  
  
  if(conn_ptr){  
    printf("Connection success\n");  
  }else{  
    printf("Connection failed\n"); 
  }  
  
  mysql_close(conn_ptr); 
  
 // system("pause");
  return 0;
}
