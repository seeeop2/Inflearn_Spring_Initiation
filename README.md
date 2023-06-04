# 섹션 1 

## 빌드하고 실행하기

### 터미널에서 빌드하고 실행하는 방법
1. 프로젝트 파일로 이동.
2. 목록을 조회
3. gradlew.bat은 Windows에서 빌드하는 파일, gradlew 파일은 Mac에서 빌드하는 파일.
4. ```./gradlew build``` 입력
5. build폴더로 이동 후, libs 폴더로 이동하면 생성된 .jar 파일 확인 가능
6. java -jar {jar파일명.jar}
7. 실행 완료

### 추가적인 명령어
1. ll : ls -al 명령어의 축약형. 디렉토리 내 각 파일들의 권한, 날짜 및 이름을 한꺼번에 볼 수 있다.
2. ls -arlth : 모든 파일, 폴더를 시간 역순으로 출력. 윈도우에서는 별도 옵션 없이 dir만 사용하면 된다.
3. ./gradlew clean : build 폴더 삭제
4. ./gradlew clean build : build 폴더 삭제 후 다시 build

### 터미널에서 실행시킨 프로그램 종료하기
- Ctrl + Z : 정지
- Ctrl + C : 종료

#### 주의사항
만약 'ctrl + z'를 누른 후 다른 IDE에서 같은 프로그램을 실행시키면 이미 port를 사용하고 있다고 충돌이 발생할 수 있다.


# 섹션 2

## 정적 컨텐츠
hello-static처럼 관련 컨트롤러가 없는 html파일은 localhost:{port번호}/{파일명}.html 입력 시 정적으로 보여준다.





