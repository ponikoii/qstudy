# QStudy (빠른 스터디 모음 - 백엔드)

### 0. 서론

QStudy에서 백엔드 부분 입니다.

`Spring Boot`로 구성이 되어 있으며, `MVC`패턴과 `RestFul API`기준으로 작성되었습니다.

<br/>

### 1. 배포

Cafe24 Cloud PC를 통해 배포를 마쳤으며, Jenkins을 사용하여 무중단 배포를 시도하였으나 깃허브 키의 지속적인 삭제로 인해 보류하게 되었습니다.

</br>

### 2. API

만들어진 API는 Postman으로 확인할 수 있습니다. <br/>
[QStudy.postman_collection.json](https://github.com/iam6ukk/qstudy/files/14652047/QStudy.postman_collection.json)

Swagger로 제작될 예정 입니다.

<br/>

### 3. 아키텍처

![스크린샷 2024-03-19 234602](https://github.com/iam6ukk/qstudy/assets/59737252/2086561b-528f-4d94-a94f-db86dc7dfcb8)

버전정보
- centOS : 7
- React : 18.2
- Node : 19.5.0
- Java : 17.0.7
- Spring Boot : 3


<br/>

![db](https://github.com/iam6ukk/qstudy/assets/59737252/c062e596-11a8-4311-b612-a87e3676cbb9)

- qsuty_attend : 그룹에 참여한 목록 테이블
- group_list : 그룹 전체 리스트
- group_view : 중간 작업을 원활하게 하기 위한 뷰 테이블
- calendar : 달력 관련 목록 테이블
- userprofile : 사용자 목록 프로필 (SSO 적용)
