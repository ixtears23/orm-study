## 자바 ORM 표준 JPA 프로그래밍 Study

> 최신 라이브러리를 사용해서 예제 실습 및 추가 실습


### 라이브러리 버전
- Java 1.8
- Java Persistence 2.2 Schema Resources
- h2database 2.1.214
- hibernate-entitymanager 5.6.10.Final
- h2 Version 2.1.214 (2022-06-13)


### h2 실행 방법
1. h2 Version 2.1.214 (2022-06-13) 다운로드 받은 뒤 압축 해제
2. h2 이름의 폴더가 생성 됨
3. ./h2/bin 폴더에서 shell 스크립트 실행  
`$ sh h2.sh`
4. browser 에 h2 console 이 실행 됨  
만약 실행되지 않으면 browser에서  `http://localhost:8082/login.do` 접속
5. ServerMode로 실행하려면 두번 접속해야 함. 
6. Embedded mode 접속 - 접속정보
- Generic H2 (Embedded)
- org.h2.Driver
- jdbc:h2:~/test
- sa 
7. Serve mode 접속 - 접속정보
- Generic H2 (Server)
- org.h2.Driver
- jdbc:h2:tcp://localhost/~/test
- sa 
