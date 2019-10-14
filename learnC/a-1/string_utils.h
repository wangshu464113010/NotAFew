#ifndef STRING_UTILS_H_INCLUDED
#define STRING_UTILS_H_INCLUDED

int string_length(char * str);
int longstring_contain_shortstring(char* longstring,char* shortstring);
void string_first_lowercase(char * str);
int string_copy_exclusive_last_char(char * target_string,char * source_string,int n);
int string_convert_int(char * s);
#endif // STRING_UTILS_H_INCLUDED
