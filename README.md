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

## MVC와 템플릿 엔진
과거에는 View와 Controller를 함께 JSP에서 사용했다. 이것을 MVC 패턴 1이라고 부르고, 현재에는 View와 Controller를 나눈 MVC 패턴 2를 사용.

### Thymeleaf의 장점
html을 그대로 사용하고, html파일을 서버 없이 열어봐도 껍데기를 확인 가능.
```
<p th:text="'hello ' + ${name}">hello! empty </p> 
```
서버가 돌고 Controller를 탔다면, 태그 안의 'hello ' + ${name}이 화면에 떴을 것이고,
정적으로 접근하면 hello! empty가 화면에 뜬다.

### @RequestParam(value = "{value}" , required = { true | false })
아무것도 넘겨주는 것 없이 페이지를 띄울려고 하면 오류가 뜬다.
required 옵션을 줘서 false를 주면 값을 안 넘겨줘도 화면이 뜨긴 한다.
물론 적지 않으면 default값 true 적용된다.



