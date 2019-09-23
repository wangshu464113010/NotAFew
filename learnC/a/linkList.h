#ifndef LINKLIST_H_INCLUDED
#define LINKLIST_H_INCLUDED

#define LIST_HEAD_INIT(name) {&(name),&(name)}

#define LIST_HEAD(name) \
    struct link_List name = LIST_HEAD_INIT(name)

typedef struct link_List{
   struct link_List *previous;
   struct link_List *next;
}linkList;
typedef struct testData{
    linkList * _list;
    int a;
    double b;
}tdata;
//typedef struct link_List linkList;
void init_list_head(linkList *list);
void linklist_add(linkList *new,linkList * prev);
void linklist_remove();


#endif // LINKLIST_H_INCLUDED
