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

### 5. 공격하기
- URL: `/games`
- Method: `POST`

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
