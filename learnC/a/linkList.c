#include "linkList.h"

 void init_list_head(linkList *list)
{
    list->next = list;
    list->previous = list;
}

 void linklist_add(linkList *newNode,linkList *_list_)
{
    newNode->next = _list_->next->previous;
    _list_->next = newNode;//�������һ���ڵ� = new�ĵ�ַ
    newNode->previous = _list_;
/*
    new->next = prev;
    new->previous = next;
    next = new;
    prev = new->next;*/
}
void linklist_remove()
{

}
