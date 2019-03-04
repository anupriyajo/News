import fetch from 'cross-fetch'

export const REQUEST_NEWS = 'REQUEST_NEWS'
export const RECEIVE_NEWS = 'RECEIVE_NEWS'

export const REQUEST_POP_NEWS = 'REQUEST_POP_NEWS'
export const RECEIVE_POP_NEWS = 'RECEIVE_POP_NEWS'

export const SAVE_RATING = 'SAVE_RATING'
export const SAVE_RATING_SUCCESS = 'SAVE_RATING_SUCCESS'
//export const SAVE_RATING_FAILURE = 'SAVE_RATING_FAILURE'

export function saveRating({newsId, rating}) {
  return dispatch => {
    dispatch(inititateSaveRating())
    return fetch(`http://192.168.0.4:8080/api/news/${newsId}/rating?rating=${rating}`,{
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        "userId" : "1"
      }/*,
      body: JSON.stringify({
        rating: rating
      })*/
    })
    .then(response => response.json())
    .then(json => dispatch(saveRatingSuccess(json)))
    .catch(error => dispatch(saveRatingFailure(error)));
  }
}
function inititateSaveRating() {
  return {
    type: SAVE_RATING
  }
}

export function saveRatingSuccess(json) {
  console.log("Rating saved:", json);
  return {
    type: SAVE_RATING_SUCCESS,
    data: json
  }
}

function saveRatingFailure(error) {
  console.error('saveRatingFailure Error:', error)
  // TODO: dispatch failure to UI
}

function requestNews() {
  return {
    type: REQUEST_NEWS
  }
}

function receiveNews(json) {
  return {
    type: RECEIVE_NEWS,
    newsItems: json,
    receivedAt: Date.now()
  }
}

export function fetchNews() {
  return dispatch => {
    dispatch(requestNews())
    return fetch(`http://192.168.0.4:8080/api/news`)
      .then(response => response.json())
      .then(json => dispatch(receiveNews(json)))
  }
}

function requestPopNews() {
  return {
    type: REQUEST_POP_NEWS
  }
}

function receivePopNews(json) {
  return {
    type: RECEIVE_POP_NEWS,
    newsItems: json,
    receivedAt: Date.now()
  }
}

export function fetchPopNews() {
  return dispatch => {
    dispatch(requestPopNews())
    return fetch(`http://192.168.0.4:8080/api/news/popular`)
      .then(response => response.json())
      .then(json => dispatch(receivePopNews(json)))
  }
}