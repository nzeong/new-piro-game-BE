# 🎴 카드게임 리팩토링

## ⭐ ERD
<a href="https://www.erdcloud.com/d/LzMNy3G6WFxt4GiCj">ERD 클라우드 링크</a>

## ⭐ API 명세서

### 1. 메인화면
- URL: `/`
- Method: `GET`

### 2. 로그인
- URL: `/login`
- Method: `POST`

### 3. 로그아웃
- URL: `/logout`
- Method: `POST`

### 4. 회원가입
- URL: `/join`
- Method: `POST`
---
- 회원가입 성공한 경우
![회원가입 성공](https://github.com/nzeong/Spring-study/assets/121355994/68ac0277-17ff-4995-927a-88d980b9148f)
- User의 name이 같아 회원가입 실패한 경우
![회원가입 실패](https://github.com/nzeong/Spring-study/assets/121355994/03f2d600-e990-4c1e-b6ca-bd30ba52f5f9)

### 5. 공격하기
- URL: `/attack`
- Method: `GET`

- [o] 1~10 사이의 랜덤 정수 5개와 현재 존재하는 모든 유저의 닉네임을 보여준다.
    - [] 자기 자신의 닉네임은 보이지 않는다.

- URL: `/attack`
- Method: `POST`

- [o] 로그인한 유저는 숫자 5개 중 하나를 골라 다른 유저를 공격할 수 있다.

### 6. 게임전적
- URL: `/games`
- Method: `GET`

### 7. 게임정보(DETAIL)
- URL: `/games/<int:pk>`
- Method: `GET`

### 8. 게임취소
- URL: `/games/<int:pk>`
- Method: `DELETE`

### 9. 반격하기
- URL: `/games/<int:pk>`
- Method: `POST`

### 10. 랭킹보기 페이지
- URL: `/rankings`
- Method: `GET`
