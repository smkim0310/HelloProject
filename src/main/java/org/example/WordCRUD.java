package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{

    ArrayList<Word> list;
    final String fname="dictionary.txt";
    Scanner kb=new Scanner(System.in);

    WordCRUD(){
        list=new ArrayList<>();
        this.kb=kb;
    }
    @Override
    public Object add() {
        System.out.print("\n=> 난이도(1,2,3)와 단어 입력: ");
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
        System.out.println("\n-----------------------");
        for(int i=0;i<list.size();i++){
            System.out.print((i+1)+" ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("-----------------------\n");
    }

    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idlist=new ArrayList<>();
        int j=0;

        System.out.println("\n-----------------------");
        for(int i=0;i<list.size();i++){
            String word=list.get(i).getName();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1)+" ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("-----------------------\n");
        return idlist;
    }

    public void updateItem() {
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword=kb.next();
        ArrayList<Integer> idlist=this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택 : ");
        int id=kb.nextInt();
        kb.nextLine();

        System.out.print("=> 뜻 입력 : ");
        String meaning=kb.nextLine();
        Word word=list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다.");
    }

    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword=kb.next();
        ArrayList<Integer> idlist=this.listAll(keyword);
        System.out.print("=> 삭제할 번호 선택 : ");
        int id=kb.nextInt();
        kb.nextLine();

        System.out.print("=> 삭제하시겠습니까? (Y/N) : ");
        String ans=kb.nextLine();
        if(ans.equalsIgnoreCase("y")){
            list.remove((int)idlist.get(id-1));
            System.out.println("단어가 삭제되었습니다.");
        }
        else System.out.println("취소되었습니다.");
    }

    public void loadFile(){
        try {
            BufferedReader bf=new BufferedReader(new FileReader(fname));
            String line;

            int count=0;
            while(true) {
                line = bf.readLine();
                if(line==null) break;

                String data[] = line.split("\\|");
                int level=Integer.parseInt(data[0]);
                String word=data[1];
                String meaning=data[2];
                list.add(new Word(0,level,word,meaning));
                count++;
            }
            bf.close();
            System.out.println("==> "+count+"개 단어 로딩 완료!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveFile() {
        try {
            PrintWriter pr=new PrintWriter(new FileWriter(fname));
            for(Word one:list){
                pr.write(one.toFileString()+"\n");
            }

            pr.close();
            System.out.println("==> 데이터 저장 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
