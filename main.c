#include <stdio.h>
struct student{
    int rollno;
    char name[20];
    int age;
    int marks[5];
    int total;
    float percentage;
    char grade[3];
}
int main(){
    struct student s;
    return 0;
}