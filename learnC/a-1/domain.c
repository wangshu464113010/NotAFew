#include "domain.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

    const char * const _private = "    private ";
    const char * const _public = "    public ";
    const char * const _void = "void ";
    const char * const _byte = "byte ";
    const char * const _short = "short ";
    const char * const _char = "char ";
    const char * const _int = "int ";
    const char * const _long = "long ";
    const char * const _float = "float ";
    const char * const _double = "double ";
    const char * const _bool = "boolean ";

    const char * const _Byte = "Byte ";
    const char * const _Short = "Short ";
    const char * const _Character = "Character ";
    const char * const _Integer = "Integer ";
    const char * const _Long = "Long ";
    const char * const _Float = "Float ";
    const char * const _Double =  "Double ";
    const char * const _Boolean = "Boolean ";
    const char * const _String = "String ";
    const char * const _Date = "Date ";
    const char * const _BigDecimal = "BigDecimal ";

void create(const char * const  fileName,int length)
{
   // int count = 0;
    printf("filename = %s\n",fileName);
    char * p = (char*)fileName;
    while(*p)p++;
    char *filePath = (char*)malloc((p - fileName +100) * sizeof(char));
  //  FILE *fp = fopen("./a.java","w+");
    strcpy(filePath,".\\");
    strcat(filePath,fileName);
    strcat(filePath,".java");
    printf("filePath = %s\n", filePath);
    FILE *fp = fopen(filePath,"w+");
    fputs("package com.a...;\n\n",fp);
    fputs("public class ",fp);
    fputs(fileName,fp);
    fputs(" {",fp);
    fputs("\n\n}",fp);
    fclose(fp);
    free(filePath);
}
void write_fields_file(char * fileContent)
{

    //char * _semicolon = ";\n";
    // ×Ö¶ÎÀàÐÍ£¬×Ö¶ÎÃû£¬

}
void write_function_set()
{
    //char * _public = "    public ";
  /*  public void setFunctionName(Integer FieldName){
       this.FieldName = FieldName;
    }*/

}
void write_function_get()
{

}
void write_function_construtor()
{

}
