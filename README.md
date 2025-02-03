# 유기견 보호소 관리 시스템

## Class Diragram

<img src="https://github.com/user-attachments/assets/b385f1bd-af67-4a9a-ad8d-8586b26afc5d" width="50%" height="30%" />

## 프로그램 설명
유기견 보호소에서 유기견을 관리하고, 분양하는 **관리 프로그램** 입니다.

```agsl
1. 관리자 / 사용자 / 종료
  1. 관리자
    1. 동물 등록
      - 이름
      - 나이(0이상 숫자)
      - 성별(수컷, 암컷)
      - 종류
      - 가격(0이상 숫자)
      - 건강상태(지정된 enum)
      - 훈련도(0~100)
    2. 동물 조회
    3. 동물 수정
    4. 동물 삭제
    5. 분양동물 조회
    6. 이전

  2. 사용자
    1. 동물 조회
    2. 동물 구매
      1. 구매자 정보 입력(사람 등록)
        - 이름
        - 전화번호
        - 주소
        - 재산(2000만원 미만은 분양 불가)
      2. 구매할 동물 선택
    3. 이전
  3. 종료
```
- **Dog**와 **Puppy**의 차이는 분양의 여부입니다. 이미 분양된 동물의 경우 주인을 등록해 관리하라 필요성이 있기 때문입니다.
