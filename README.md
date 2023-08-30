Master 브런치에는 안드로이드 스튜디오를 사용한 프론트엔드 프로젝트를, <br>
[jimins2 브런치](https://github.com/4th-Oasis-Hackathon/AjaajaYajasu/tree/jimin2)에는 스프링부트를 사용한 백엔드 프로젝트를 커밋했습니다.

REST API 통신 라이브러리인 Retrofit2를 사용하여 프론트엔드와 벡엔드 시스템을 서로 통신하였습니다.





# 개요

4회 오아시스 해커톤에 참가한 아자아자야자수 팀의 프론트엔드 개발 보고서

개발 요약
- NestedScrollView를 사용하여 한정된 화면에 더 많은 정보를 표시
- 챗봇 메시지 전송시 애니메이션을 적용하여 유저의 상호작용을 극대화
- 공통된 하단 네비게이션바를 적용하여 화면의 일반화 및 유저의 일관적이고 편리한 경험을 제공

# 상세

## 한정된 화면에 더 많은 정보를 표시

![](https://velog.velcdn.com/images/2jooin1207/post/d3fa2934-b86a-4696-a42b-ab82340de4df/image.PNG)

구현 방식 및 특징
- 서비스 이용자가 더 나은 경험을 하기 위해선 서비스의 메인 화면은 한눈에 정보가 보여져야 함.
- NestedScrollView를 사용하여 상하좌우 스크롤을 가능하게 하였고, 한정된 화면에 많은 정보를 표시할 수 있음.
- 또한 사용자의 자연스러운 제스처 사용유도가 가능.

## 챗봇 메시지에 애니메이션을 적용하여 상호작용을 극대화

구현방식 및 특징
- smoothScrollToPosition을 사용하여 챗봇 채팅장에 표시되는 메시지에 캐스케이딩(Cascading) 효과를 적용함.
- 색깔과 애니메이션을 통해 챗봇이 반환한 메시지를 강조하였으며, 유저와의 상호작용을 극대화 하였음.
- 또한 메시지가 연속적이라는 느낌을 주었음.

※ 캐스케이딩 효과 : 여러 개의 카드 또는 메시지가 위에서 아래로 펼쳐져서 표시될때, 약간의 딜레이를 가지며 나타나는 효과.


MyFlowerChatFragment.java
~~~
    void addToChat(String message, String sentBy) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message, sentBy));
                messageAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });
    }

~~~



## 공통된 UI를 통해 일관되고 차별화된 경험을 제공

![](https://velog.velcdn.com/images/2jooin1207/post/ad1fd1fa-5297-4c9e-8ef7-982f6562cb2f/image.PNG)


구현 방식 및 특징
- mainActivity 위에서 Fragment를 전환하는 방식으로 앱을 구현하여 하단 네비게이션 바를 공통적으로 표시되도록 하였으며, mainActivity의 onTabSelected 메서드를 인터페이스 상속을 통해 다른 프래그먼트에서도 사용할 수 있게하였다. <br>
  클릭 효과를 통해 하단 네비게이션 바에서 현재 어느 탭에 머물고 있는지 표시되도록 하여 보다 쉬운 서비스 이용이 되도록 하였음.
- 하단 네비게이션 바에는 맞춤 꽃 추천 서비스와 꽃 클래스 신청 기능, 커뮤니티 기능, 마이페이지 등이 연결되도록 함<br>
   


