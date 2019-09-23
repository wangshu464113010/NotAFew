#include <stdio.h>
#include <stdlib.h>
#include "linkList.h"
#include "domain.h"

#include <winsock2.h> //因为要进行网络连接
#include <mysql.h> //因为使用了MySQL C API访问mysql数据库
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
    printf("查询结束\n");
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
    MYSQL mysql; //mysql数据库连接
    mysql_init(&mysql);//初始化mysql连接

    char host[]="127.0.0.1";//MYSQL服务器的主机名或IP，本机为localhost
    char user[]="root";//mysql数据库登录的用户名
    char passwd[]="123456";//mysql数据库登录的密码
    char db[]="learn";//要连接的数据库名
    unsigned int port=3306;//MySQL服务器的TCP/IP端口号，默认为3306
    char *unixSocket=NULL;//连接类型
    unsigned int clientFlag=CLIENT_FOUND_ROWS;//MySQL运行ODBC数据库的标记

    MYSQL_RES *res_ptr; //指向查询结果的指针
    MYSQL_FIELD *field; //指向字段结构体的指针
    MYSQL_ROW result_row; //按行返回的select结果，即一行记录。
    int rowCnt, colCnt; //select结果返回的记录行数和列数
    int res; //执行sql语句后的返回标志
    int i, j;

    //建立mysql连接
    if (NULL != mysql_real_connect(&mysql,host,user,passwd,db,port,unixSocket,clientFlag))
    {
        //连接成功
        printf("数据库连接成功！\n");

        //设置查询编码为gbk,以支持中文
        mysql_query(&mysql, "set names gbk");

        char *sql;
        //select table_name from information_schema.`TABLES` where table_schema = 'learn';
        sql="select table_name from information_schema.`TABLES` where table_schema = \'learn\'"; //SQL语句。
        res = mysql_query(&mysql, sql);
        if (res)   //执行查询语句失败
        {
            printf("查询语句执行失败 !\n");
            //关闭连接
            mysql_close(&mysql);
        }
        else     //查询语句执行成功
        {
            //将查询的结果赋值给res_ptr
            res_ptr = mysql_store_result(&mysql);
            //如果记录集不为空，就把每条记录按行输出
            if (res_ptr)
            {
                //取得结果记录集的行数和字段数
                rowCnt = mysql_num_rows(res_ptr);
                colCnt = mysql_num_fields(res_ptr);
                printf("查询到 %d 行 \n", rowCnt);
                //输出记录的字段名
                for (i = 0; (field = mysql_fetch_field(res_ptr)); i++)//=>for (i = 0; field = mysql_fetch_field(res_ptr); i++)
                {
                     printf("%10s ", field->name);
                }
                printf("\n");
                //按行输出每条记录
                for (i = 1; i < rowCnt+1; i++)
                {
                    result_row = mysql_fetch_row(res_ptr);
                    for (j = 0; j < colCnt; j++)
                        printf("%10s ", result_row[j]);
                    printf("\n");
                }
            }
            //最后，不再使用数据库时，请不要忘了关闭连接，释放资源。
            mysql_close(&mysql);
        }
    }
    else
    {
        printf("数据库连接失败！");
    }
}
