package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{

    ArrayList<Word> list;
    Scanner kb=new Scanner(System.in);

    WordCRUD(){
        list=new ArrayList<>();
        this.kb=kb;
    }
    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3)와 단어 입력: ");
        int level= kb.nextInt();
        String word=kb.nextLine();

        System.out.print("뜻 입력: ");
        String meaning=kb.nextLine();
        return new Word(0,level,word,meaning);
    }
    public void addWord(){
        Word one=(Word)add();
        list.add(one);
        System.out.println(one.getName()+"가 추가되었습니다.\n");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    public void listAll(){
        System.out.println("-----------------------");
        for(int i=0;i<list.size();i++){
             System.out.print((i+1)+" ");
             System.out.println(list.get(i).toString());
        }
        System.out.println("-----------------------");
    }
}
