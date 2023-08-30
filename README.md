# 개요

4회 오아시스 해커톤에 참가한 아자아자야자수 팀의 백엔드 개발 보고서.

개발 요약
- 스프링부트와 Chat gpt를 사용한 Rest api 구현.
- SNS 공유 api를 통해 추천 결과를 다른 사람들과 공유하여 서비스 이용자의 지속적인 사용과 확장을 유도
- 부트스트랩을 사용한 반응형 웹 디자인을 활용하여 웹, 모바일 환경 모두 같은 디자인을 적용하여
  웹, 모바일 환경 모두 동일한 경험이 가능.
  
# 상세

## Chat Gpt api를 사용한 사용자 개개인에 맞춘 꽃 추천 기능

구현 방식 및 특징
- open ai 에서 제공하는 GPT-3.5 모델 중 하나인 text-davinci-003을 사용.
- text-davinci-003의 특징으로 이전 모델보다 더 나은 성능을 가진 언어처리능력 보유, 텍스트 완성 삽입 기능을 보유.
- 역할(Role)을 지정하여 답변 방식과 내용의 방향성을 고정하였음.
  -> 서비스 이용자가 질문과 아무런 상관이 없는 응답을 하더라도 챗봇은 꽃과 관련된 답변으로 반환함.

  ex) 명령 프롬포트를 사용한 방향성 고정
  ~~~
  public String getFlowerImagin(String answer) {
        String question =
                /*
                    앞의 대화는 잊고, 현제 제공하는 문장에서 추천하는 꽃의 이름을 말해라.
                    이때 대답 형식은 다음과 같다.
                    flower : 꽃 이름 (꽃의 영어 이름)
                 */
                "Forget the conversation we've had so far.\n" +
                "Tell me the name of the flower you recommend in the next conversation.\n" +
                "The conditions are as follows.\n" +
                "1. Just say the name of the flower.\n" +
                "2. The answer format must be as follows.\n" +
                    "flower : flower name in korean (flower name in English)\n" +
                "3. The name of the flower answered in English and the name of the flower answered in Korean must be the same."
                + answer;
        String image = chatgptService.sendMessage(question);
  ~~~

##  SNS 공유 api를 사용한 추천결과 공유

구현 방식 및 특징
- 카카오톡, 인스타 공유 api를 통해 서비스 홍보 및 확장을 유도.
- 동적으로 메시지를 구성하여 결과를 공유한다.

  ex) ProductController.java에서 model.attribute로 추천 결과를
  shareSns.html의 Kakao.Share.createCustomButton에 넘기면 카카오톡 메시지 탬플릿의 내용이 변경된다.
  
  ProductController.java
  ~~~
    @PostMapping("/chat")
    @ResponseBody
    public String sendMessage(@RequestBody String userMessage) {

        botMessages.add(userMessage);

        String botResponse = chatService.chatQna(botMessages.size(), botMessages);

        botMessages.add(botResponse);
        log.info("user message : " + userMessage + " size : " + botMessages.size());

        return botResponse;
    }
  ~~~

  shareSns.html
  ~~~
  Kakao.Share.createCustomButton({
    container: '#kakaotalk-sharing-btn',
    templateId: 97832,
    templateArgs: {
      image : info.recommendImage,
      title: info.recommendName,
      desc: info.recommendContent
    },
  });
  ~~~

  ![](https://velog.velcdn.com/images/2jooin1207/post/d042907c-0c50-4cea-a57f-a0214fc7018e/image.PNG)


## Ajax 통신을 사용한 챗봇 구현(부트스트랩을 사용한 기능 테스트)

구현 방식 및 특징
- Chat gpt api를 사용한 챗봇의 답변은 Ajax통신을 사용하여 비동기 방식을 통해 바로 받아온다.
- 부트스트랩을 사용한 반응형 웹 디자인을 활용하여 웹, 모바일 환경 모두 같은 디자인을 적용 가능.
- 단, 이 브런치 코드의 경우 안드로이드 앱의 백엔드 rest api이므로, 기능 테스트 용도로만 사용하였음.

# 



