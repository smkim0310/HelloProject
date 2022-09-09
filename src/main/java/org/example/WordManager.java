package org.example;

import java.util.Scanner;

public class WordManager {
    Scanner kb=new Scanner(System.in);
    WordCRUD wordCRUD;

    WordManager(){
        wordCRUD=new WordCRUD();
    }

    public int selectMenu(){
        System.out.print("나만의 영어 단어장\n*************\n" +
                "1.모든 단어\n2.수준별 단어\n3.단어 검색\n" +
                "4.단어 추가\n5.단어 수정\n6.단어 삭제\n" +
                "7.파일 저장\n0.나가기\n*************\n" +
                "=> 원하는 메뉴는? ");
        return kb.nextInt();
    }

    public void start(){
        while (true) {
            int menu = selectMenu();
            if (menu==0){
                System.out.println("이용해 주셔서 감사합니다!!");
                break;
            }
            if(menu==1){
                wordCRUD.listAll();
            }
            else if(menu==4){
                wordCRUD.addWord();
            }
            else if(menu==5){
                wordCRUD.updateItem();
            }
            else if(menu==6){

            }

        }
    }
}
