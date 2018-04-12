package com.example.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.dao.AuthorityRepository;
import com.example.dao.LineProgressRepository;
import com.example.dao.RequestRepository;
import com.example.dao.UserInformationRepository;
import com.example.entities.LineProgress;
import com.example.entities.Request;
import com.example.entities.UserInformation;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.action.Action;
import com.linecorp.bot.model.action.DatetimePickerAction;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.action.PostbackAction;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.PostbackEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.model.message.template.ConfirmTemplate;
import com.linecorp.bot.model.response.BotApiResponse;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

@Slf4j
@LineMessageHandler
@RestController
public class BotController {
	Logger logger = LoggerFactory.getLogger(BotController.class);
	public static final String TOKEN = "OBna57cOodEGIIqhcSEjjpkjT0AUOl/AZNumYYcxT+H5T3ep6VRSXOOf5pyIRICy5QQ1ytWFUv1Ol5+1Pb2wOWk5+44idmC"
			+ "jlP6vancpqEmWHw9YZHZ0/2H4qn1jCl3AZ88XIo2WkFPylumplMuSlAdB04t89/1O/w1cDnyilFU=";

	@Autowired
	LineMessagingClient lineMessagingClient;
	@Autowired
	UserInformationRepository userInformationRepository;
	@Autowired
	RequestRepository requestRepository;
	@Autowired
	LineProgressRepository lineProgressRepository;
	@Autowired
	AuthorityRepository authorityRepository;

	@EventMapping
	public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
		TextMessageContent message = event.getMessage();
		handleTextContent(event.getReplyToken(), event, message);
	}

	private static String createUri(String path) {
		return ServletUriComponentsBuilder.fromCurrentContextPath().path(path).build().toUriString();
	}

	String title, detail, authority;
	UserInformation toUser;
	long visibility;
	LineProgress lineProgress = new LineProgress();
	CarouselColumn carouselColumn;
	String userId;
	List<CarouselColumn> listOfCarouselColumns;

	@ResponseBody
	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	private Map<String, Object> webhook(@RequestBody Map<String, Object> obj) throws JSONException, IOException {
		String channelToken = TOKEN;

		Map<String, Object> json = new HashMap<>();
		JSONObject jsonResult = new JSONObject(obj);
		JSONObject rsl = jsonResult.getJSONObject("originalRequest");
		JSONObject data = rsl.getJSONObject("data");
		JSONObject source = data.getJSONObject("source");
		JSONObject message = data.getJSONObject("message");
		userId = source.getString("userId");
		String customerMessage = message.getString("text");
		String timestamp = jsonResult.getString("timestamp");
		JSONObject result = jsonResult.getJSONObject("result");
		String resolvedQuery = result.getString("resolvedQuery");
		// String action = result.getString("action");
		JSONObject metadata = result.getJSONObject("metadata");
		String intentName = metadata.getString("intentName");
		JSONObject parameters = result.getJSONObject("parameters");
		// JSONObject fulfillment = result.getJSONObject("fulfillment");
		// String speech = fulfillment.getString("speech");
		// JSONArray messages = fulfillment.getJSONArray("messages");
		// JSONObject msg = messages.getJSONObject(0);
		// String speechMessage = msg.getString("speech");

		LinkedHashMap<String, String> hm = new LinkedHashMap<>();

		logger.info("in intente name ****** '{}'" + intentName);
		logger.info("in resolved Query ****** '{}'" + resolvedQuery);
		logger.info("status ************" + lineProgress.getStatusLine());
		logger.info("timestamp*********" + timestamp);
		logger.info("timestamp*********" + jsonResult);

		switch (intentName.toLowerCase()) {

		case "language":

			hm.put("English", "English");
			hm.put("日本語", "日本語");
			typeBRecursiveChoices(null, null, "Please select a language:", hm, channelToken, userId);
			logger.info("Choose a Language :" + customerMessage);

			break;

		case "selected language":

			if (customerMessage.equals("English")) {

				LineMessagingClient client = LineMessagingClient.builder(channelToken).build();
				TextMessage textMessage = new TextMessage("Now, I am speaking English");
				PushMessage pushMessage = new PushMessage(userId, textMessage);
				BotApiResponse botApiResponse;
				try {
					botApiResponse = client.pushMessage(pushMessage).get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
					return json;
				}
				System.out.println(botApiResponse);
				logger.info("Langauge ***********" + resolvedQuery);
			}

			else {

				LineMessagingClient client = LineMessagingClient.builder(channelToken).build();
				TextMessage textMessage = new TextMessage("じゃ、日本語で話しますね。");
				PushMessage pushMessage = new PushMessage(userId, textMessage);
				BotApiResponse botApiResponse;
				try {
					botApiResponse = client.pushMessage(pushMessage).get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
					return json;
				}
				System.out.println(botApiResponse);
				logger.info("Langauge ***********" + resolvedQuery);
			}

			break;

		case "request":

			LineMessagingClient client = LineMessagingClient.builder(channelToken).build();
			TextMessage textMessage = new TextMessage("Receiver name :");
			PushMessage pushMessage = new PushMessage(userId, textMessage);
			BotApiResponse botApiResponse;
			try {
				botApiResponse = client.pushMessage(pushMessage).get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				return json;
			}
			System.out.println(botApiResponse);
			logger.info("Request ***********" + resolvedQuery);

			break;
		case "default fallback intent":

			lineProgress.setUserLine(userInformationRepository.getOne(userId));
			customerMessage = customerMessage.toLowerCase();
			logger.info("customer Message in lower case : " + customerMessage);

			switch (lineProgress.getStatusLine()) {

			case "Default":

				List<UserInformation> user = userInformationRepository.findUserByName("%" + customerMessage + "%", null)
						.getContent();
				int a = user.size();

				for (int i = 0; i < a; i++) {
					hm.put(user.get(i).getUserName(), user.get(i).getUserName());
				}

				typeBRecursiveChoices(null, null, "Do you mean:", hm, channelToken, userId);

				lineProgress.setStatusLine("receiverchosen");
				lineProgressRepository.save(lineProgress);
				System.out.println("status*********" + lineProgress.getStatusLine());

				break;

			case "receiverchosen":

				user = userInformationRepository.findUserByName("%" + customerMessage + "%", null).getContent();
				a = user.size();

				for (int i = 0; i < a; i++) {

					String x = user.get(i).getUserName();
					logger.info("who is the receiver ****************" + x);

					if (customerMessage.equals(x)) {
						String receiverId = user.get(i).getUserId();
						UserInformation receiver = userInformationRepository.findOne(receiverId);
						toUser = receiver;
						logger.info("the receiver is ++++++++++++ ****************" + toUser);

						lineProgress.setStatusLine("Requesttitled");
						lineProgressRepository.save(lineProgress);

						LineMessagingClient client2 = LineMessagingClient.builder(channelToken).build();
						TextMessage textMessage2 = new TextMessage("Request Title :");
						PushMessage pushMessage2 = new PushMessage(userId, textMessage2);
						BotApiResponse botApiResponse2;
						try {
							botApiResponse2 = client2.pushMessage(pushMessage2).get();
						} catch (InterruptedException | ExecutionException e) {
							e.printStackTrace();
							return json;
						}
						System.out.println(botApiResponse2);
						logger.info("receiver has been chosen" + customerMessage);
					} else {
						lineProgress.setStatusLine("Default");
						lineProgressRepository.save(lineProgress);
						System.out.println("status*********" + lineProgress.getStatusLine());
						logger.info("receiver has noooooooot been chosen" + customerMessage);

						LineMessagingClient client2 = LineMessagingClient.builder(channelToken).build();
						TextMessage textMessage2 = new TextMessage("Try Again, receiver name :");
						PushMessage pushMessage2 = new PushMessage(userId, textMessage2);
						BotApiResponse botApiResponse2;
						try {
							botApiResponse2 = client2.pushMessage(pushMessage2).get();
						} catch (InterruptedException | ExecutionException e) {
							e.printStackTrace();
							return json;
						}
						System.out.println(botApiResponse2);
					}
				}

				break;

			case "Requesttitled":

				title = resolvedQuery;

				lineProgress.setStatusLine("RequestDetailed");
				lineProgressRepository.save(lineProgress);
				System.out.println("status*********" + lineProgress.getStatusLine());
				logger.info("Request Titled " + customerMessage);

				LineMessagingClient client3 = LineMessagingClient.builder(channelToken).build();
				TextMessage textMessage3 = new TextMessage("Request Detail :");
				PushMessage pushMessage3 = new PushMessage(userId, textMessage3);
				BotApiResponse botApiResponse3;
				try {
					botApiResponse3 = client3.pushMessage(pushMessage3).get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
					return json;
				}
				System.out.println(botApiResponse3);

				break;

			case "RequestDetailed":

				detail = resolvedQuery;

				lineProgress.setStatusLine("Default");
				lineProgressRepository.save(lineProgress);
				System.out.println("status*********" + lineProgress.getStatusLine());
				logger.info("Request detailed", customerMessage);

				hm.put("1 : Director", "Director");
				hm.put("2 : Manager", "Manager");
				hm.put("3 : Team leader", "Team leader");
				hm.put("4 : Developer", "Developer");
				typeBRecursiveChoices(null, null, "Please select the request authority:", hm, channelToken, userId);
				logger.info("Choose request authority :" + customerMessage);

				break;
			}

			break;

		case "authority":

			switch (customerMessage) {

			case "Director":
				visibility = 1;
				authority = customerMessage;
				break;

			case "Manager":
				visibility = 2;
				authority = customerMessage;
				break;

			case "Team leader":
				visibility = 3;
				authority = customerMessage;
				break;

			case "Developer":
				visibility = 4;
				authority = customerMessage;
				break;
			}

			typeCQuestion(
					"Do you want to send the request? \nRECEIVER: " + toUser.getUserName() + "\nTITLE: " + title
							+ "\nDETAIL: " + detail + "\nAUTHORITY: " + authority,
					"Send", "Send", "Cancel", "Cancel", "Confirm", channelToken, userId);

			break;

		case "confirm":

			logger.info("request decesion**************************" + customerMessage);

			if (customerMessage.equals("Send")) {

				Request request = new Request();
				request.setTitle(title);
				request.setDetail(detail);
				request.setToUser(toUser);
				request.setFromUser(userId);
				request.setVisibility(visibility);
				request.setCreatedAt(timestamp);
				request.setUpdatedAt(timestamp);
				requestRepository.save(request);

				LineMessagingClient client3 = LineMessagingClient.builder(channelToken).build();
				TextMessage textMessage3 = new TextMessage("Your request has been sent successfully.");
				PushMessage pushMessage3 = new PushMessage(userId, textMessage3);
				BotApiResponse botApiResponse3;
				try {
					botApiResponse3 = client3.pushMessage(pushMessage3).get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
					return json;
				}
				System.out.println(botApiResponse3);

			} else {

				lineProgressRepository.delete(lineProgress);

				LineMessagingClient client3 = LineMessagingClient.builder(channelToken).build();
				TextMessage textMessage3 = new TextMessage("Your request has been deleted.");
				PushMessage pushMessage3 = new PushMessage(userId, textMessage3);
				BotApiResponse botApiResponse3;
				try {
					botApiResponse3 = client3.pushMessage(pushMessage3).get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
					return json;
				}
				System.out.println(botApiResponse3);

			}

			break;

		case "history":

			if (customerMessage.equals("Decision history")) {

				//
				// List<CarouselColumn> carouselColumnList = new ArrayList<>();
				// List<CarouselColumn> carouselColumnListFinal = new ArrayList<>();
				// List<Request> requests = requestRepository.findAll();
				//
				// int finished = 0;
				// for (Request req : requests) {
				// if (userId != null && userId.equals(req.getToUser().getUserId())
				// && (req.getStatus().equals("pending") || (req.getStatus().equals("passed"))))
				// {
				// logger.info("carousel *************************");
				// carouselColumn = new CarouselColumn(
				// "https://image.ibb.co/eSTgEx/Capture_d_cran_de_2018_03_09_12_50_03.png",
				// "Request title: " + req.getTitle(),
				// "FROM: " + userInformationRepository.findOne(req.getFromUser()).getUserName()
				// + "\nDETAIL: " + req.getDetail(),
				// Arrays.asList(new MessageAction("Approve", "Approve request" +
				// req.getRequestId()),
				// new MessageAction("Disapprove", "Disapprove request" + req.getRequestId())));
				//
				// carouselColumnList.add(carouselColumn);
				// logger.info("carousel list***************" + carouselColumnList.size());
				//
				// } else {
				// finished++;
				// System.out.println("carouselColumnList " + carouselColumnList.size());
				// carouselColumnListFinal.clear();
				// carouselColumnListFinal.addAll(carouselColumnList);
				// System.out.println(finished + " finished");
				//
				// }
				// if (finished == 1) {
				// CarouselTemplate carouselTemplate = new
				// CarouselTemplate(carouselColumnListFinal);
				// TemplateMessage templateMessage = new TemplateMessage("Carousel",
				// carouselTemplate);
				// PushMessage pushMessage1 = new PushMessage(userId, templateMessage);
				// try {
				// LineMessagingServiceBuilder.create(channelToken).build().pushMessage(pushMessage1)
				// .execute();
				// } catch (IOException e) {
				// e.printStackTrace();
				// }
				// logger.info("osakaaaaaaaaaaaaaaaaaaaa");
				// }
				// }

				CarouselTemplate carouselTemplate = new CarouselTemplate(collectCarouselColumns());
				TemplateMessage templateMessage = new TemplateMessage("Carousel alt text", carouselTemplate);
				PushMessage pushMessage1 = new PushMessage(userId, templateMessage);
				LineMessagingServiceBuilder.create(channelToken).build().pushMessage(pushMessage1).execute();
				logger.info("osaka :" + customerMessage);

			} else {
				String[] table = customerMessage.split(" ");
				String part1 = table[0];

				switch (part1) {
				case "Approve":

					long number = parameters.getLong("number");
					Request r = requestRepository.findOne(number);
					r.setStatus("approved");
					requestRepository.save(r);
					logger.info("approooooooooooooooved");

					break;

				case "Disapprove":

					long number1 = parameters.getLong("number");
					Request r1 = requestRepository.findOne(number1);
					r1.setStatus("approved");
					requestRepository.save(r1);
					logger.info("disapproooooooooooooooved");

					break;
				}

			}

			break;

		case "carousel":

			String imageUrl = "https://image.ibb.co/eSTgEx/Capture_d_cran_de_2018_03_09_12_50_03.png"; // createUri("/static/buttons/1040.jpg");
			CarouselTemplate carouselTemplate = new CarouselTemplate(Arrays.asList(
					new CarouselColumn(imageUrl, "hoge", "fuga",
							Arrays.asList(new URIAction("Go to line.me", "https://line.me"),
									new URIAction("Go to line.me", "https://line.me"),
									new PostbackAction("Say hello1", "hello こんにちは"))),
					new CarouselColumn(imageUrl, "hoge", "fuga",
							Arrays.asList(new PostbackAction("言 hello2", "hello こんにちは", "hello こんにちは"),
									new PostbackAction("言 hello2", "hello こんにちは", "hello こんにちは"),
									new MessageAction("Say message", "Rice=米"))),
					new CarouselColumn(imageUrl, "Datetime Picker", "Please select a date, time or datetime",
							Arrays.asList(
									new DatetimePickerAction("Datetime", "action=sel", "datetime", "2017-06-18T06:15",
											"2100-12-31T23:59", "1900-01-01T00:00"),
									new DatetimePickerAction("Date", "action=sel&only=date", "date", "2017-06-18",
											"2100-12-31", "1900-01-01"),
									new DatetimePickerAction("Time", "action=sel&only=time", "time", "06:15", "23:59",
											"00:00")))));
			TemplateMessage templateMessage = new TemplateMessage("Carousel alt text", carouselTemplate);
			PushMessage pushMessage1 = new PushMessage(userId, templateMessage);
			LineMessagingServiceBuilder.create(channelToken).build().pushMessage(pushMessage1).execute();
			logger.info("osaka :" + customerMessage);

			break;

		case "menu":

			hm.put("Osaka", "osaka");
			hm.put("Tokyo", "tokyo");
			hm.put("London", "london");
			typeBRecursiveChoices(
					"https://lh3.googleusercontent.com/oKsgcsHtHu_nIkpNd-mNCAyzUD8xo68laRPOfvFuO0hqv6nDXVNNjEMmoiv9tIDgTj8=w170",
					" boldTitle", " normalTitle", hm, channelToken, userId);
			logger.info("paris :" + customerMessage);

			break;

		case "type b":

			hm.put("Osaka", "osaka");
			hm.put("Tokyo", "tokyo");
			typeBRecursiveChoices(
					"https://lh3.googleusercontent.com/oKsgcsHtHu_nIkpNd-mNCAyzUD8xo68laRPOfvFuO0hqv6nDXVNNjEMmoiv9tIDgTj8=w170",
					" boldTitle", " normalTitle", hm, channelToken, userId);
			logger.info("see more :", customerMessage);

			break;

		case "b2":

			hm = new LinkedHashMap<>();
			hm.put("Osaka", "osaka");
			hm.put("Tokyo", "tokyo");
			hm.put("London", "london");
			typeBChoices(
					"https://lh3.googleusercontent.com/oKsgcsHtHu_nIkpNd-mNCAyzUD8xo68laRPOfvFuO0hqv6nDXVNNjEMmoiv9tIDgTj8=w170",
					" boldTitle", " normalTitle", hm, "Next or see more", "Next or see more answer", channelToken,
					userId);
			logger.info("London :", customerMessage);

			break;

		case "date":

			typeDQuestion(
					"https://lh3.googleusercontent.com/oKsgcsHtHu_nIkpNd-mNCAyzUD8xo68laRPOfvFuO0hqv6nDXVNNjEMmoiv9tIDgTj8=w170",
					channelToken, userId);

			break;

		default:

			sendAlertViaSlack(userId, timestamp, customerMessage);
			logger.info("slack :" + customerMessage);

			break;
		}

		return json;

	}

	private List<CarouselColumn> collectCarouselColumns() {
		String imageUrl = "https://image.ibb.co/eSTgEx/Capture_d_cran_de_2018_03_09_12_50_03.png"; // createUri("/static/buttons/1040.jpg");
		List<Request> requests = requestRepository.findAll();
		listOfCarouselColumns = new ArrayList<>();
		logger.info("size of requests is =" + requests.size());
		for (int i = 0; i < 3; i++) {
			listOfCarouselColumns.add(buildCarouselColumn(imageUrl, "Request title: " + requests.get(i).getTitle(),
					"FROM:" + userInformationRepository.findOne(requests.get(i).getFromUser()).getUserName()
							+ "\nDETAIL: " + requests.get(i).getDetail(),
					Arrays.asList(buildMessageAction("Approve", "Approve request" + requests.get(i).getRequestId()),
							buildMessageAction("Disapprove", "Disapprove request" + requests.get(i).getRequestId()))));

		}

		return listOfCarouselColumns;
	}

	private CarouselColumn buildCarouselColumn(String thumbnailImageUrl, String titre, String text,
			List<Action> actions) {
		return new CarouselColumn(thumbnailImageUrl, titre, text, actions);
	}

	private Action buildMessageAction(String label, String text) {
		return new MessageAction(label, text);
	}

	@EventMapping
	public void handlePostbackEvent(PostbackEvent event) {
		String replyToken = event.getReplyToken();
		logger.info(replyToken + "Got postback data " + event.getPostbackContent().getData() + ", param "
				+ event.getPostbackContent().getParams().toString());
	}

	private void handleTextContent(String replyToken, Event event, TextMessageContent content) throws Exception {
		String text = content.getText();
		String channelToken = "OBna57cOodEGIIqhcSEjjpkjT0AUOl/AZNumYYcxT+H5T3ep6VRSXOOf5pyIRICy5QQ1ytWFUv1Ol5+1Pb2wOWk5+44idmCjlP6vancpqEmWHw9YZHZ0/2H4qn1jCl3AZ88XIo2WkFPylumplMuSlAdB04t89/1O/w1cDnyilFU=";
		logger.info("Got text message from {}: {}" + replyToken + text);
		switch (text) {
		case "paris": {
			String userId = event.getSource().getUserId();
			if (userId != null) {

				typeDQuestion(
						"https://lh3.googleusercontent.com/oKsgcsHtHu_nIkpNd-mNCAyzUD8xo68laRPOfvFuO0hqv6nDXVNNjEMmoiv9tIDgTj8=w170",
						channelToken, userId);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info(content.toString());

			}
			break;
		}
		default:
			logger.info("Returns echo message {}: {}" + replyToken + text);
			logger.info(replyToken + text);
			break;
		}

	}

	/**
	 * Method for send carousel template message to use
	 * 
	 * @param userId
	 * @param lChannelAccessToken
	 * @param nameSatff1
	 * @param nameSatff2
	 * @param poster1_url
	 * @param poster2_url
	 * @throws IOException
	 */
	private void carouselForUser(String userId, String lChannelAccessToken, java.util.List<String> randomLinks)
			throws IOException {

		java.util.List<CarouselColumn> columns = new ArrayList<>();

		for (String link : randomLinks) {
			Document doc = Jsoup.connect(link).get();
			String title = doc.getElementsByClass("tit_articleName").get(0).text();
			String img = doc.getElementsByClass("max-width-260").get(0).attr("abs:src");

			CarouselColumn column = new CarouselColumn(img, title, "Click check for more details",
					Arrays.asList(new URIAction("check", link)));
			columns.add(column);
		}

		CarouselTemplate carouselTemplate = new CarouselTemplate(columns);

		TemplateMessage templateMessage = new TemplateMessage("Your search result", carouselTemplate);
		PushMessage pushMessage = new PushMessage(userId, templateMessage);
		try {
			Response<BotApiResponse> response = LineMessagingServiceBuilder.create(lChannelAccessToken).build()
					.pushMessage(pushMessage).execute();
			logger.info(response.code() + " " + response.message());
		} catch (IOException e) {
			logger.info("Exception is raised ");
			e.printStackTrace();
		}
	}

	/**
	 * TypeC template
	 * 
	 * @param userId
	 * @param channelToken
	 * @param msgTemplate
	 * @param msgFirstAnswer
	 * @param msgSecondAnswer
	 * @param titleTemplate
	 * @throws IOException
	 */
	public void typeCQuestion(String msgTemplate, String msgFirstAnswer, String msgFirstAnswerToSend,
			String msgSecondAnswer, String msgSecondAnswerToSend, String titleTemplate, String channelToken,
			String userId) throws IOException {
		ConfirmTemplate confirmTemplate = new ConfirmTemplate(msgTemplate,
				new MessageAction(msgFirstAnswer, msgFirstAnswerToSend),
				new MessageAction(msgSecondAnswer, msgSecondAnswerToSend));
		TemplateMessage templateMessage = new TemplateMessage(titleTemplate, confirmTemplate);
		PushMessage pushMessage = new PushMessage(userId, templateMessage);
		LineMessagingServiceBuilder.create(channelToken).build().pushMessage(pushMessage).execute();

	}

	/**
	 * TypeB template
	 * 
	 * @param userId
	 * @param channelToken
	 * @param imageURL
	 * @param boldTitle
	 * @param normalTitle
	 * @param buttonHint
	 * @param messageToSend
	 * @throws IOException
	 */
	public void typeBQuestion(String imageURL, String boldTitle, String normalTitle, String buttonHint,
			String messageToSend, String channelToken, String userId) throws IOException {
		ButtonsTemplate buttonsTemplate = new ButtonsTemplate(imageURL, boldTitle, normalTitle, Arrays.asList(
				new URIAction("Go to line.me", "https://line.me"), new MessageAction(buttonHint, messageToSend)));
		TemplateMessage templateMessage = new TemplateMessage("Button alt text", buttonsTemplate);
		PushMessage pushMessage = new PushMessage(userId, templateMessage);
		LineMessagingServiceBuilder.create(channelToken).build().pushMessage(pushMessage).execute();
	}

	/**
	 * TypeB template
	 * 
	 * @param userId
	 * @param channelToken
	 * @param imageURL
	 * @param boldTitle
	 * @param normalTitle
	 * @param buttonHint
	 * @param messageToSend
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public void typeBChoices(String imageURL, String boldTitle, String normalTitle, LinkedHashMap<String, String> hm,
			String nextOrSeeMore, String nextOrSeeMoreAnswer, String channelToken, String userId) throws IOException {
		List<Action> messageActions = new ArrayList<>();
		for (Map.Entry m : hm.entrySet()) {
			MessageAction ma = new MessageAction(m.getKey().toString(), m.getValue().toString());
			messageActions.add(ma);
		}
		messageActions.add(new MessageAction(nextOrSeeMore, nextOrSeeMoreAnswer));
		ButtonsTemplate buttonsTemplate = new ButtonsTemplate(imageURL, boldTitle, normalTitle, messageActions);

		TemplateMessage templateMessage = new TemplateMessage("Button alt text", buttonsTemplate);
		PushMessage pushMessage = new PushMessage(userId, templateMessage);
		LineMessagingServiceBuilder.create(channelToken).build().pushMessage(pushMessage).execute();
	}

	/**
	 * TypeD template Date-Calendar
	 * 
	 * @param userId
	 * @param channelToken
	 * @param imageURL
	 * @param boldTitle
	 * @param normalTitle
	 * @param buttonHint
	 * @param messageToSend
	 * @throws IOException
	 */
	public void typeDQuestion(String imageUrl, String channelToken, String userId) throws IOException {
		logger.info("CALENDAAAAAAAAAAAARRRR");
		DatetimePickerAction date = new DatetimePickerAction("Date", "action=sel", "date");
		CarouselTemplate carouselTemplate = new CarouselTemplate(Arrays.asList(
				new CarouselColumn("https://cdn2.iconfinder.com/data/icons/employment-business/256/Job_Search-512.png",
						"Datetime Picker", "Please select a date, time or datetime", Arrays.asList(date))));
		TemplateMessage templateMessage1 = new TemplateMessage("date time picker", carouselTemplate);
		ReplyMessage pushMessage1 = new ReplyMessage(userId, templateMessage1);
		logger.info("push message is \n " + pushMessage1);
		logger.info(templateMessage1.getTemplate().toString());
		LineMessagingServiceBuilder.create(channelToken).build().replyMessage(pushMessage1);
		logger.info("response is \n " + Arrays.toString(pushMessage1.getMessages().toArray()));

		// LineMessagingClient.builder(channelToken).build().replyMessage(pushMessage1);
	}

	public void typeBRecursiveChoices(String imageURL, String boldTitle, String normalTitle, Map<String, String> hm,
			String channelToken, String userId) throws IOException {
		List<Action> messageActions = new ArrayList<>();
		hm.size();
		if (hm.size() <= 4) {
			for (Map.Entry m : hm.entrySet()) {
				MessageAction ma = new MessageAction(m.getKey().toString(), m.getValue().toString());
				messageActions.add(ma);
			}
			// messageActions.add(new MessageAction("N/A", "not available"));
			ButtonsTemplate buttonsTemplate = new ButtonsTemplate(imageURL, boldTitle, normalTitle, messageActions);

			TemplateMessage templateMessage = new TemplateMessage("Button alt text", buttonsTemplate);
			PushMessage pushMessage = new PushMessage(userId, templateMessage);
			LineMessagingServiceBuilder.create(channelToken).build().pushMessage(pushMessage).execute();

		}
	}

	/**
	 * @author Aymanov
	 * @param userId
	 *            : user line ID
	 * @param timestamp:
	 *            message timestamp
	 * @param customerMessage:
	 *            text to send via slack
	 * 
	 *            method to send unknown messages to slack channel
	 * @throws JSONException
	 */
	private void sendAlertViaSlack(String userId, String timestamp, String customerMessage) throws JSONException {
		String uri = "https://hooks.slack.com/services/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";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String input = "userId:" + userId + " \n time: " + timestamp + " \n text: " + customerMessage + "";
		JSONObject jsonSlack = new JSONObject();
		jsonSlack.put("text", input);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonSlack.toString(), headers);
		restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	}

	private void checkLineFunction(@RequestBody Map<String, Object> obj) throws JSONException, IOException {
		String channelToken = "OBna57cOodEGIIqhcSEjjpkjT0AUOl/AZNumYYcxT+H5T3ep6VRSXOOf5pyIRICy5QQ1ytWFUv1Ol5+1Pb2wOWk5+44idmCjlP6vancpqEmWHw9YZHZ0/2H4qn1jCl3AZ88XIo2WkFPylumplMuSlAdB04t89/1O/w1cDnyilFU=";

		JSONObject jsonResult = new JSONObject(obj);
		JSONObject rsl = jsonResult.getJSONObject("originalRequest");
		JSONObject data = rsl.getJSONObject("data");
		JSONObject source = data.getJSONObject("source");
		JSONObject message = data.getJSONObject("message");
		String userId = source.getString("userId");
		String customerMessage = message.getString("text");
		String timestamp = jsonResult.getString("timestamp");
		JSONObject result = jsonResult.getJSONObject("result");
		JSONObject metadata = result.getJSONObject("metadata");
		String intentName = metadata.getString("intentName");
		JSONObject parameters = result.getJSONObject("parameters");
		JSONObject fulfillment = result.getJSONObject("fulfillment");
		String speech = fulfillment.getString("speech");

		List<EventHelper> eventHelpers = new ArrayList<>();
		eventHelpers.add(new EventHelper(1, "chooseLanguage", "initial", "C", null, "osaka"));
		eventHelpers.add(new EventHelper(2, "writeStation", "intermediate", "E", 1, "paris"));
		eventHelpers.add(new EventHelper(3, "keywordStation", "intermediate", "B", 2, "tokyo"));
		eventHelpers.add(new EventHelper(4, "whichTime", "intermediate", "B", 3, "london"));
		eventHelpers.add(new EventHelper(5, "whichJob", "intermediate", "f", 4, "help"));

		LinkedHashMap<String, String> hm = new LinkedHashMap<>();
		hm.put("Osaka", "osaka");
		hm.put("Tokyo", "tokyo");
		hm.put("London", "london");

		String msgTemplate = "Choose Language";
		String msgFirstAnswer = "English";
		String msgSecondAnswer = "Japanese";
		String titleTemplate = "Choose Language";
		String msgSecondAnswerToSend = "English";
		String msgFirstAnswerToSend = "Japanese";

		for (EventHelper eventHelper : eventHelpers) {
			if (intentName.equalsIgnoreCase(eventHelper.getIntentName()))

				switch (eventHelper.getTypeFunction().toLowerCase()) {
				/*
				 * case "a": typeBChoices(
				 * "https://cdn2.iconfinder.com/data/icons/employment-business/256/Job_Search-512.png",
				 * "boldTitle ", " normalTitle", hm, "nextOrSeeMore", "nextOrSeeMoreAnswer",
				 * channelToken, userId); break;
				 */
				case "b":

					String imageURL = "https://cdn2.iconfinder.com/data/icons/employment-business/256/Job_Search-512.png";
					String boldTitle = "boldTitle ";
					String normalTitle = " normalTitle";

					String nextOrSeeMore = "nextOrSeeMore";
					String nextOrSeeMoreAnswer = "nextOrSeeMore";

					int idEvent = 2;
					BQuestion bQuestion = new BQuestion(imageURL, boldTitle, normalTitle, hm, nextOrSeeMore,
							nextOrSeeMoreAnswer, idEvent);
					if (bQuestion.getIdEvent() == eventHelper.getIdEvent())
						typeBChoices(bQuestion.getImageURL(), bQuestion.getBoldTitle(), bQuestion.getNormalTitle(), hm,
								bQuestion.getNextOrSeeMore(), bQuestion.getNextOrSeeMoreAnswer(), channelToken, userId);
					break;
				case "c":
					CQuestion cQuestion = new CQuestion(msgTemplate, msgFirstAnswer, msgSecondAnswer, titleTemplate,
							msgSecondAnswerToSend, msgFirstAnswerToSend, 1);
					if (cQuestion.getIdEvent() == eventHelper.getIdEvent())

						typeCQuestion(cQuestion.getMsgTemplate(), cQuestion.getMsgFirstAnswer(),
								cQuestion.getMsgFirstAnswerToSend(), cQuestion.getMsgSecondAnswer(),
								cQuestion.getMsgSecondAnswerToSend(), cQuestion.getTitleTemplate(), channelToken,
								userId);
					break;

				case "e":

					break;
				case "d":
					typeDQuestion("https://cdn2.iconfinder.com/data/icons/employment-business/256/Job_Search-512.png",
							channelToken, userId);
					break;
				case "f":
					sendAlertViaSlack(userId, timestamp, customerMessage);
					break;
				default:
					break;
				}

		}

	}

}
