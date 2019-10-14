#include <stdio.h>
#include <stdlib.h>
#include "linkList.h"
#include "domain.h"
#include "string_utils.h"

#include <winsock2.h> //��ΪҪ������������
#include <mysql.h> //��Ϊʹ����MySQL C API����mysql���ݿ�
char* mysql_host0;
char* mysql_name0;
char* mysql_password0;
char* mysql_port0;
int mysql_port1;
char* mysql_database0;
/*
gcc.exe -Wall -g -I..\..\mysql-8.0.17-winx64\mysql-8.0.17-winx64\include -c D:\2345Downloads\a\main.c -o obj\Debug\main.o
g++.exe -L..\..\mysql-8.0.17-winx64\mysql-8.0.17-winx64\bin -o bin\Debug\a.exe obj\Debug\domain.o obj\Debug\linkList.o obj\Debug\main.o   ..\..\mysql-8.0.17-winx64\mysql-8.0.17-winx64\lib\libmysql.lib
*/
void firstLineToFile(char * filePath);
void configFile_copyto_mysql(char * line);
void connect_mySQL();
void f(char * fileName)
{
    int count = 0;
    while(*fileName)
    {
        count++;
        fileName++;
    }
}

extern char * _private;
void readFileToMySQL();

/**********************************************************/
int main(int argc, char const *argv[])
{

//    printf("longstring_contain_shortstring = %d  \n",longstring_contain_shortstring("123456789","234"));
	readFileToMySQL();

   // printf("%s\n",_private);
    /* printf("sizeof int = %d\n",sizeof(int));
     printf("sizeof int = %d\n",sizeof(int*));*/
    char a[] = "abcdsnafkdjskf";
    f(a);
    connect_mySQL();
    printf("��ѯ����\n");
    // firstLineToFile("D:\\360Downloads\\first.xml");
    /* LIST_HEAD(name);
     LIST_HEAD(a) ;
     list_add(&a,name.previous,name.next);
     printf("%p\n",name.next);
     printf("%p\n",name.previous);
     printf("%p\n",name.next->next);*/

    //string_first_lowercase(a);
    create(a,sizeof(a));
    printf("\n%s\n",a);
    system("pause");
    return 0;
}
///��ȡ�����ļ��������ļ���mysql.properties
void readFileToMySQL()
{
    FILE *fp = fopen("./mysql.properties","r");
    printf("read mysql.properties config file...\n");
    if(!fp){
        printf("open file fail(file may does not exist and so on),exiting program.");
        exit(0);
    }
	char *line = (char*)malloc(sizeof(char) * 128);
	while(!feof(fp)){
        fgets(line,1000,fp);
        configFile_copyto_mysql(line);
        memset(line,'\0',128);//�ڴ����ú�������line�����128���ֽ�����Ϊ\0
	}
	mysql_port1 = string_convert_int(mysql_port0);
//	printf("mysql_port1 = %d \n",mysql_port1);
	//printf("\n");
    printf("mysql_host = %s\n",mysql_host0);
    printf("mysql_name = %s\n",mysql_name0);
    printf("mysql_password = %s\n","*********");
    printf("mysql_port = %s\n",mysql_port0);
    printf("mysql_database = %s\n",mysql_database0);
	free(line);
    fclose(fp);
    printf("close mysql.properties config file...\n");
}
void configFile_copyto_mysql(char * line)
{
    char * p = line;
    char * host = "host";
    char * user = "user";
    char * password = "password";
    char * port = "port";
    char * db = "db";
    if(longstring_contain_shortstring(line,host)){
        for(int i = 0;i<strlen(host);++i,++p);
        ++p;
        mysql_host0 = (char*)calloc(sizeof(char) * 50,sizeof(char));//�����ڴ溯������������ֵΪ��
//        printf("p->length = %d \n",strlen(p));
        string_copy_exclusive_last_char(mysql_host0,p,strlen(p)-1);
//        printf("mysql_host0 = %s",mysql_host0);
//        printf("mysql_host0->length = %d \n",strlen(mysql_host0));
    }
    if(longstring_contain_shortstring(line,user)){
        for(int i = 0;i<strlen(user);++i,++p);
        ++p;
        mysql_name0 = (char*)calloc(sizeof(char) * 50,sizeof(char));
//        strcpy(mysql_name0,p);
        string_copy_exclusive_last_char(mysql_name0,p,strlen(p)-1);
    }
    if(longstring_contain_shortstring(line,password)){
        for(int i = 0;i<strlen(password);++i,++p);
        ++p;
        mysql_password0 = (char*)calloc(sizeof(char) * 50,sizeof(char));
//        strcpy(mysql_password0,p);
        string_copy_exclusive_last_char(mysql_password0,p,strlen(p)-1);
    }
    if(longstring_contain_shortstring(line,port)){
        for(int i = 0;i<strlen(port);++i,++p);
        ++p;
        mysql_port0 = (char*)calloc(sizeof(char) * 50,sizeof(char));
//        strcpy(mysql_port0,p);
        string_copy_exclusive_last_char(mysql_port0,p,strlen(p)-1);
    }
    if(longstring_contain_shortstring(line,db)){
        for(int i = 0;i<strlen(db);++i,++p);
        ++p;
        mysql_database0 = (char*)calloc(sizeof(char) * 50,sizeof(char));
        string_copy_exclusive_last_char(mysql_database0,p,strlen(p)-1);
    }
}

void firstLineToFile(char * filePath)
{
    char xmlFirstLine[] = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
    char xmlSecondLine[] = "<!DOCTYPE ... >";
    FILE *fp = fopen(filePath,"w+");
    if(!fp)
    {
        printf("open file fail,exiting program");
        exit(0);
    }
    fprintf(fp,xmlFirstLine);
    fputs(xmlSecondLine,fp);
    printf("successful");
    fclose(fp);
}


void connect_mySQL()
{
    MYSQL mysql; //mysql���ݿ�����
    mysql_init(&mysql);//��ʼ��mysql����
/**
mysql_host0;
mysql_name0;
mysql_password0;
mysql_port0;
mysql_port1;
mysql_database0;
	*/
    char* host= mysql_host0;//MYSQL����������������IP������Ϊlocalhost
    char* user= mysql_name0;//mysql���ݿ��¼���û���
    char* passwd= mysql_password0;//mysql���ݿ��¼������
    char* db= mysql_database0;//Ҫ���ӵ����ݿ���
    unsigned int port= mysql_port1;//MySQL��������TCP/IP�˿ںţ�Ĭ��Ϊ3306
    char *unixSocket=NULL;//��������
    unsigned int clientFlag=CLIENT_FOUND_ROWS;//MySQL����ODBC���ݿ�ı��

    MYSQL_RES *res_ptr; //ָ���ѯ�����ָ��
    MYSQL_FIELD *field; //ָ���ֶνṹ���ָ��
    MYSQL_ROW result_row; //���з��ص�select�������һ�м�¼��
    int rowCnt, colCnt; //select������صļ�¼����������
    int res; //ִ��sql����ķ��ر�־
    int i, j;

    //����mysql����
    if (NULL != mysql_real_connect(&mysql,host,user,passwd,db,port,unixSocket,clientFlag))
    {
        //���ӳɹ�
        printf("���ݿ����ӳɹ���\n");

        //���ò�ѯ����Ϊgbk,��֧������
        mysql_query(&mysql, "set names gbk");

        char* sql = (char*)calloc(sizeof(char)*1024,sizeof(char));
        //select table_name from information_schema.`TABLES` where table_schema = 'learn';
        //sql="select table_name from information_schema.`TABLES` where table_schema = "; //SQL��䡣
        strcat(sql,"select table_name from information_schema.`TABLES` where table_schema = ");
        strcat(sql,"\'");
        strcat(sql,db);
        strcat(sql,"\'");
        res = mysql_query(&mysql, sql);
        if (res)   //ִ�в�ѯ���ʧ��
        {
            printf("��ѯ���ִ��ʧ�� !\n");
            //�ر�����
            mysql_close(&mysql);
        }
        else     //��ѯ���ִ�гɹ�
        {
            //����ѯ�Ľ����ֵ��res_ptr
            res_ptr = mysql_store_result(&mysql);
            //�����¼����Ϊ�գ��Ͱ�ÿ����¼�������
            if (res_ptr)
            {
                //ȡ�ý����¼�����������ֶ���
                rowCnt = mysql_num_rows(res_ptr);
                colCnt = mysql_num_fields(res_ptr);
                printf("��ѯ�� %d �� \n", rowCnt);
                //�����¼���ֶ���
                for (i = 0; (field = mysql_fetch_field(res_ptr)); i++)//=>for (i = 0; field = mysql_fetch_field(res_ptr); i++)
                {
                     printf("%10s ", field->name);
                }
                printf("\n");
                //�������ÿ����¼
                for (i = 1; i < rowCnt+1; i++)
                {
                    result_row = mysql_fetch_row(res_ptr);
                    for (j = 0; j < colCnt; j++)
                        printf("%10s ", result_row[j]);
                    printf("\n");
                }
            }
            //��󣬲���ʹ�����ݿ�ʱ���벻Ҫ���˹ر����ӣ��ͷ���Դ��
            free(sql);
            mysql_close(&mysql);
        }
    }
    else
    {
        printf("���ݿ�����ʧ�ܣ�");
    }
}
