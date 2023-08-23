import 'package:app_whatsapp/widgets/conversationList.dart';
import 'package:flutter/material.dart';

import '../model/user.dart';

class ChatPage extends StatefulWidget {
  @override
  _ChatPageState createState() => _ChatPageState();
}

class _ChatPageState extends State<ChatPage> {
  List<ChatUsers> chatUsers = [
    ChatUsers(
        name: "Contato 1",
        messageText: "+55 (31) 91111-1111",
        imageURL: "images/user.jpeg",
        time: "23:47"),
    ChatUsers(
        name: "Contato 2",
        messageText: "+55 (31) 92222-2222",
        imageURL: "images/user.jpeg",
        time: "23:17"),
    ChatUsers(
        name: "Contato 3",
        messageText: "+55 (31) 93333-3333",
        imageURL: "images/user.jpeg",
        time: "22:01"),
    ChatUsers(
        name: "Contato 4",
        messageText: "+55 (31) 94444-4444",
        imageURL: "images/user.jpeg",
        time: "19:27"),
    ChatUsers(
        name: "Contato 5",
        messageText: "+55 (31) 95555-5555",
        imageURL: "images/user.jpeg",
        time: "17:34"),
    ChatUsers(
        name: "Contato 6",
        messageText: "+55 (31) 96666-6666",
        imageURL: "images/user.jpeg",
        time: "17:05"),
    ChatUsers(
        name: "Contato 7",
        messageText: "+55 (31) 97777-7777",
        imageURL: "images/user.jpeg",
        time: "16:36"),
    ChatUsers(
        name: "Contato 8",
        messageText: "+55 (31) 98888-8888",
        imageURL: "images/user.jpeg",
        time: "16:06"),
    ChatUsers(
        name: "Contato 9",
        messageText: "+55 (31) 99999-9999",
        imageURL: "images/user.jpeg",
        time: "14:48"),
    ChatUsers(
        name: "Contato 10",
        messageText: "+55 (31) 91010-1010",
        imageURL: "images/user.jpeg",
        time: "12:39"),
    ChatUsers(
        name: "Contato 11",
        messageText: "+55 (31) 91101-1101",
        imageURL: "images/user.jpeg",
        time: "05:30"),
    ChatUsers(
        name: "Contato 12",
        messageText: "+55 (31) 91212-1212",
        imageURL: "images/user.jpeg",
        time: "Yesterday"),
    ChatUsers(
        name: "Contato 13",
        messageText: "+55 (31) 91313-1313",
        imageURL: "images/user.jpeg",
        time: "Yesterday"),
    ChatUsers(
        name: "Contato 14",
        messageText: "+55 (31) 91414-1414",
        imageURL: "images/user.jpeg",
        time: "Yesterday"),
    ChatUsers(
        name: "Contato 15",
        messageText: "+55 (31) 91515-1515",
        imageURL: "images/user.jpeg",
        time: "Yesterday"),
    
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        physics: BouncingScrollPhysics(),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            ListView.builder(
              itemCount: chatUsers.length,
              shrinkWrap: true,
              padding: EdgeInsets.only(top: 8),
              physics: NeverScrollableScrollPhysics(),
              itemBuilder: (context, index) {
                return ConversationList(
                  name: chatUsers[index].name,
                  messageText: chatUsers[index].messageText,
                  imageUrl: chatUsers[index].imageURL,
                  time: chatUsers[index].time,
                  isMessageRead: (index == 0 || index == 3) ? true : false,
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}
