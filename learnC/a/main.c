#include <stdio.h>
#include <stdlib.h>
#include "linkList.h"
#include "domain.h"

#include <winsock2.h> //��ΪҪ������������
#include <mysql.h> //��Ϊʹ����MySQL C API����mysql���ݿ�
/*
gcc.exe -Wall -g -I..\..\mysql-8.0.17-winx64\mysql-8.0.17-winx64\include -c D:\2345Downloads\a\main.c -o obj\Debug\main.o
g++.exe -L..\..\mysql-8.0.17-winx64\mysql-8.0.17-winx64\bin -o bin\Debug\a.exe obj\Debug\domain.o obj\Debug\linkList.o obj\Debug\main.o   ..\..\mysql-8.0.17-winx64\mysql-8.0.17-winx64\lib\libmysql.lib
*/
void firstLineToFile(char * filePath);
void string_first_lowercase(char * str);
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

/**********************************************************/
int main(int argc, char const *argv[])
{
    printf("%s\n",_private);
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
void string_first_lowercase(char * str)
{
    if(str != NULL && str[0] >= 'A' && str[0]<='Z')
    {
        str[0] = str[0] + ('a' - 'A');
    }
    // printf("%c\n",&str[0]);
}


void connect_mySQL()
{
    MYSQL mysql; //mysql���ݿ�����
    mysql_init(&mysql);//��ʼ��mysql����

    char host[]="127.0.0.1";//MYSQL����������������IP������Ϊlocalhost
    char user[]="root";//mysql���ݿ��¼���û���
    char passwd[]="123456";//mysql���ݿ��¼������
    char db[]="learn";//Ҫ���ӵ����ݿ���
    unsigned int port=3306;//MySQL��������TCP/IP�˿ںţ�Ĭ��Ϊ3306
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

        char *sql;
        //select table_name from information_schema.`TABLES` where table_schema = 'learn';
        sql="select table_name from information_schema.`TABLES` where table_schema = \'learn\'"; //SQL��䡣
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
            mysql_close(&mysql);
        }
    }
    else
    {
        printf("���ݿ�����ʧ�ܣ�");
    }
}
