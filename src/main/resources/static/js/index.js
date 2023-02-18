let isLoading = false;

window.addEventListener('keyup', e => {
  if (e.keyCode != 13) {
    return;
  }
  translateKeyword();
});

function translateKeyword() {
  const keyword = document.getElementById('schKeyword').value;
  if (keyword.length == 0) {
    alert('검색어를 입력하세요');
    document.getElementById('schKeyword').focus;
    return;
  }

  const locale = setLocale(keyword);
  console.log(locale);
  const query = new URLSearchParams({keyword, locale}).toString()
  if (isLoading) {
    return;
  }
  isLoading = true;
  fetch(`http://localhost:8080/translate/arabic?${query}`)
      .then((res) => res.json())
      .then((data) => {
        isLoading = false;
        window.open(`https://www.google.com/search?q=${data['translateText']}&tbm=isch`, '_blank')
      })
}

function setLocale(source) {
  if (hasAllEnglish(source)) {
    return 'en';
  }
  return 'ko';
}

function hasAllEnglish(source) {
  const regex = /^[a-z|A-Z]+$/;
  return regex.test(source);
}