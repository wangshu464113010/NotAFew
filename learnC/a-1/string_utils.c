#include <stdio.h>
#include <string.h>

 // 求字符串的长度
int string_length(char * str)
{
    int len = 0;
    while(*str){
        len++;
        str++;
    }
    return len;
}
//字符串匹配
int longstring_contain_shortstring(char* longstring,char* shortstring)
{
    char * pl = longstring;
    char * ps = shortstring;
    int shortstring_length = strlen(shortstring);
    int i = 0;
    while(*pl){
        char *pl_l = pl;//pl_l指针用来移动匹配ps
        while(*ps == *pl_l){
            ++i;
            ++ps;
            ++pl_l;
        }
        if(i == shortstring_length){
            return 1;
        }else{
            ps = shortstring;//ps复位
            i = 0;
            pl++;//pl往后移动一位
        }
    }
    return 0;
}
//第一个字符改为大写
void string_first_lowercase(char * str)
{
    if(str != NULL && str[0] >= 'A' && str[0]<='Z')
    {
        str[0] = str[0] + ('a' - 'A');
    }
}
//复制指定长度字符串
int string_copy_exclusive_last_char(char * target_string,char * source_string,int n)
{
    if(n <=0){
        return 0;
    }
    int i=0;
//    char * p = target_string;
    while(i<n && *source_string){
        *target_string = *source_string;
        ++target_string;
        ++source_string;
        ++i;
    }
    return 1;
}
///字符串转换成数字
int string_convert_int(char * str)
{
    //ascii:48-25
    //0-9
    char* p = str;
    int value = 0;
    while(*p){
        if(*p>='0' && *p <= '9'){
            value = value * 10 +(*p - '0');
            ++p;
        }else{
            printf("string have other character ! program will exit .");
            exit(0);
        }
    }
}
