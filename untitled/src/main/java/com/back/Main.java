package com.back;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        int lastId = 0;
        String[] wisearr = new String[100];
        String[] authorarr = new String[100];

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            }
            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wise = sc.nextLine().trim();
                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                lastId++;

                wisearr[lastId] = wise;
                authorarr[lastId] = author;

                System.out.println(lastId + "번 명령이 등록되었습니다.");
            }
            if(cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------");

                for(int i = lastId; i>0; i--) {
                    if(wisearr[i] == null && authorarr[i] == null){
                        continue;
                    }
                    System.out.print(i+ " / ");
                    System.out.print(authorarr[i] + " / ");
                    System.out.println(wisearr[i]);
                }
            }
            if(cmd.startsWith("삭제?id=")){
                String idStr = cmd.substring(6);
                int targetId = Integer.parseInt(idStr);

                if(wisearr[targetId] == null && authorarr[targetId] == null){
                    System.out.println(targetId + "번 명언은 존재하지 않습니다.");
                }
                else {
                    wisearr[targetId] = null;
                    authorarr[targetId] = null;

                    System.out.println(targetId + "번 명언이 삭제되었습니다.");
                }
            }
            if(cmd.startsWith("수정?id=")){
                String idStr = cmd.substring(6);
                int targetId = Integer.parseInt(idStr);

                if(wisearr[targetId] == null && authorarr[targetId] == null){
                    System.out.println(targetId + "번 명언은 존재하지 않습니다.");
                }
                else {
                    System.out.println("명언(기존) : " + wisearr[targetId]);
                    System.out.print("명언 : " + authorarr[targetId]);
                    String wise = sc.nextLine().trim();
                    System.out.println("작가(기존) : ");
                    System.out.print("명언 : ");
                    String author = sc.nextLine().trim();

                    wisearr[targetId] = wise;
                    authorarr[targetId] = author;
                }
            }
        }
    }
}
