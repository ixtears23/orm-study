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

### wiki
- [3장 영속성 관리](https://github.com/ixtears23/orm-study/wiki/3%EC%9E%A5-%EC%98%81%EC%86%8D%EC%84%B1-%EA%B4%80%EB%A6%AC)

###  Summary  

**연관관계 주인**  
*mappedBy* 는 양방향 연관관계 일 때 사용  
주인의 반대편은 *mappedBy*로 주인을 지정해야 함  
*mappedBy* 값은 연관관계 주인 클래스의 보인 객체 참조 필드 값을 주면 된다  
예) Member(N) : Team(1) 의 관계

```java
import javax.persistence.OneToMany;

class Member {
    // ... Member 테이블이 Team 테이블의 id 인 TEAM_ID 외래키를 가지고 있다.
    private Team team;
}

class Team {
    @OneToMany(mappedBy = "team") // 연관관계 주인인 Member 클래스의 team 필드로 설정
    private List<Member> members;
}
```


**연간관계의 주인을 정하는 기준**  
단방향 : 항상 외래 키가 있는 곳을 기준으로 매핑  
양방향 : 비즈니스 로직의 중요도가 아닌 외래 키 관리자 정도의 의미 부여로 지정  
예) 회원(N) : 팀(1) - 외래키가 있는 회원(N) 쪽이 연관관계의 주인이 됨  
예) 자동차의 차체(1) : 바퀴(N) - 차체가 더 중요해 보이지만 외래키를 가지고 있는 바퀴(N) 를 연관관계의 주인으로 정해야 함  
> 연관관계의 주인은 외래 키의 위치와 관련해서 정해야지 비즈니스 중요도로 접근근하면 안 된다.
  
연관관계의 주인만이 데이터베이스 연관관계와 매핑되고 외래 키를 관리(등록, 수정, 삭제)할 수 있다.  
주인이 아닌 쪽은 읽기만 할 수 있다.  

연관관계의 주인을 정한다는 것은 외래 키 관리자를 선택하는 것  

**단방향 관계(객체)**  
예) 회원(N) : 팀(1)  
UML 기준 회원 클래스가 팀 필드를 가지고 있고, 팀 클래스는 회원 필드를 가지고 있지 않은 경우  
회원에서 팀으로의 접근이 가능하지만, 팀에서 회원으로의 접근이 불가능한 경우  
한 방향으로만 접근 가능 -> 단방향 관계  


