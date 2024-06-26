# Run, Hero!
24년도 1학기 스마트폰 게임 프로그래밍 텀프로젝트

## 게임 컨셉
- 자동공격을 하는 캐릭터가 계속해서 앞으로 달려나가고, 선택지를 골라 캐릭터를 성장시키고 몬스터를 물리치며 최종보스까지 도달하는 게임

![arrow_a_row](https://github.com/dhtpgus/AndroidGame-TermProject/assets/112833359/10ebf045-69e2-4f6b-a40f-917f343e5202)
##### (출처 : https://store.steampowered.com/app/2495980/_Arrow_a_Row/?l=koreana )

## 게임 메카닉
- 플레이어는 좌, 우 키를 이용해 왼쪽, 오른쪽으로 움직일 수 있다.
- 플레이어는 유저가 컨트롤하지 못하는 자동공격(원거리 공격)을 한다.
- 게임이 진행되는 동안 다가오는 선택지를 통해 플레이어의 전투 능력을 향상시킬 수 있다.
- 선택지를 통해 중복되는 전투 능력을 향상 시킬 수 있으며, 같은 전투 능력을 향상 시킬 수록 점점 더 강해진다.
- 맵은 세로로 된 일자 모양의 길 이다.
- 몬스터는 맵 위의 랜덤한 위치에 스폰되며, 플레이어는 몬스터와 충돌하기 전에 몬스터를 자동공격을 통해 쏴 죽여야한다.
- 몬스터는 체력을 가지고 있으며, 플레이어와 충돌 시 몬스터의 남은 체력을 플레이어의 현재 체력에서 감소시킨다.
- 몬스터의 크기는 다양하며, 길 전부를 가로막고 있을 수 있다.
- 게임 종료 시 플레이 성과에 따라 보상을 주며, 보상을 모아 플레이어의 전투 능력을 영구적으로 향상 시킬 수 있다.
- ### 정리
- ##### 플레이어는 앞으로 나아가며 선택지를 골라 전투능력을 강화하고, 몬스터를 죽여야한다.
- ##### 최종 보스에 도달할 때까지 플레이어는 최대한 능력을 강화하고 체력을 보존해야한다.
- ##### 보스에 도달하지 못하고 죽더라도 그 다음 게임을 위한 보상이 주어지고, 플레이어를 영구적으로 강화할 수 있다.
## 개발 범위
#### 플레이어의 공격, 강화를 위한 선택지와 적의 자동 생성, 맵 구현, 보스, 플레이어의 영구 강화 정보 저장

#### 플레이어 공격
- 플레이어 공격은 자동으로, 일정주기로 공격되도록 구현
- 공격은 선택지를 통해 데미지, 공격속도, 공격횟수 등을 강화할 수 있음
- 선택지를 통해 고르는 공격강화는 게임에서 사망시 초기화
#### 선택지
- 플레이어 공격에 영향을 주는 데미지, 공격속도, 공격횟수, 무기추가 등의 요소
- 플레이어 체력, 이동속도 강화 등의 요소
- 선택지는 일정한 주기로 맵에 나타남
#### 적
- 선택지처럼 일정한 주기로 맵의 랜덤한 위치에 나타남
- 크기가 다양하여 플레이어의 이동 경로를 차단할 수 있음
- 게임 진행 시간에 비례하여 생성되는 적의 체력이 증가
#### 맵
- 스프라이트 애니메이션을 통해 플레이어가 이동하는 것처럼 효과를 내고, 무한으로 맵이 확장되는 듯한 느낌을 주도록 구현
#### 보스
- 최종보스와 만날 경우 더 이상 몬스터나 선택지가 나오지 않으며 최종보스의 체력을 다 깎을 경우 게임승리
- 최종보스의 난이도는 반복되는 영구적 성장을 통해 깰 수 있을 정도로 설정
- 단순한 장애물 역할의 적과 달리 플레이어에게 직접 공격
#### 플레이어 영구 강화
- 게임 종료 시 플레이 성과에 따라 지급받는 보상으로 플레이어 영구 강화
- 영구적으로 저장되는 정보라 초기화되지 않고, 게임에 저장
- 기본 데미지, 플레이어 체력, 이동속도, 종료시 보상 증가 등의 요소
## 예상 게임 실행 흐름
- 게임 시작 및 메뉴

![image](https://github.com/dhtpgus/AndroidGame-TermProject/assets/112833359/dc6ec4a6-43ea-4ef6-a8ea-42fe78dfa86e)

- 게임 진행

![image](https://github.com/dhtpgus/AndroidGame-TermProject/assets/112833359/f9f613c1-3521-45e3-a521-b93fc31fc922)

- 선택지 및 적(장애물)

![image](https://github.com/dhtpgus/AndroidGame-TermProject/assets/112833359/18d85042-6bf9-4bb6-82f1-cc0908a4d467)

- 게임 종료 및 보상

![image](https://github.com/dhtpgus/AndroidGame-TermProject/assets/112833359/4d1cd91d-5d25-46be-b698-5ed5f9499dc8)

- 플레이어 영구 강화 시스템

![image](https://github.com/dhtpgus/AndroidGame-TermProject/assets/112833359/d5efbb16-bc30-4a85-a371-ae3b751abff8)

## 개발 일정
- 1주 차 (4/4 ~ 4/7) : 리소스 수집 및 UI 배치
- 2주 차 (4/8 ~ 4/14) : 플레이어 이동 처리, 맵 구현
- 3주 차 (4/15 ~ 4/21) : 일정한 주기로 적, 선택지를 맵에 생성
- 4주 차 (4/22 ~ 4/28) : 플레이어/적, 선택지 간 충돌 처리
- 5주 차 (4/29 ~ 5/5) : 선택된 공격 강화 내용 반영
- 6주 차 (5/6 ~ 5/12) : 게임종료 시 보상처리, 플레이어 영구 강화 시스템
- 7주 차 (5/13 ~ 5/19) : 보스 구현
- 8주 차 (5/20 ~ 5/26) : 게임 데이터 저장, 미흡한 부분 추가 구현
- 9주 차 (5/27 ~ 6/2) : 밸런스 조절 및 최종 검수
