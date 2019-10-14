#ifndef DOMAIN_H_INCLUDED
#define DOMAIN_H_INCLUDED

//#define GET_FUCTION(file,name) public name get
/*
typedef struct object_keyword
{*/



/*}keyword;*/
typedef struct file_content
{
    char *  _package;
    char *  _class;
    char *  _fields;
    char *  _functions;
}fileContent;
void create(const char * const  tableName,int length);
void write_fields_file();
void write_function_set();
void write_function_get();
void write_function_get_set();
void write_function_construtor();



#endif // DOMAIN_H_INCLUDED
