# Kashish Sharma — Portfolio

![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=black)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white)
![License](https://img.shields.io/badge/license-All%20rights%20reserved-lightgrey)

A luxury, dark-and-gold themed personal developer portfolio. Built with
plain HTML/CSS/JS on the frontend and a Spring Boot service for the
contact form backend.

**Live site:** https://my-portfolio-iota-hazel-s9x7gbjarv.vercel.app/

<!-- Optional: add a screenshot once your images/content are final
![Portfolio screenshot](assets/images/screenshot.png)
-->

---

## ✨ Features

- Typing animation cycling through roles in the hero section
- Smooth scroll navigation with a fixed, blur-backdrop navbar
- Scroll-triggered fade-in animations throughout
- Vertical timeline-style Resume section (Education, Skills, Achievements)
- Click-to-expand **project modals** — see tools used and a full description
- Click-to-expand **certificate lightbox** — view certificates full-size
- Contact form wired to a real backend (Spring Boot + email)
- Fully responsive — desktop, tablet, and mobile

---

## 📁 Project structure

```
portfolio/
├── index.html
├── css/
│   └── style.css
├── js/
│   └── script.js
├── assets/
│   └── images/          ← profile photo + certificate images live here
├── backend/              ← Spring Boot service that emails contact-form submissions
│   ├── pom.xml
│   └── src/main/java/com/kashishsharma/portfolio/
│       ├── PortfolioApplication.java
│       ├── ContactController.java
│       └── ContactRequest.java
└── README.md
```

---

## 🚀 Running locally

No build step for the frontend — just open it in a browser:

```
open index.html
```

Or serve it properly so relative paths behave the same as in production:

```
npx serve .
```

---

## 🖼️ Updating content

**Profile photo** — replace `assets/images/myimage.png` (or update the
`src`/`onerror` values in the hero section of `index.html` if you rename it).

**Certificates** — currently showing:

| Certificate | Issuer        | File                                |
|-------------|---------------|--------------------------------------|
| AI Fluency  | Anthropic     | `assets/images/ai-fluency.jpeg`      |
| Java        | Scaler Topics | `assets/images/java-scaler.jpeg`     |
| MySQL       | Coursera      | `assets/images/mySqlCertificate.png` |

To add a new one, copy an existing `.cert-card` block in the Certifications
section of `index.html` and point it at your new image.

**Projects** — edit the `projectDetails` object near the top of `js/script.js`
to change the tools list or description shown in each project's modal.

**Social links** — search `index.html` for `href="#"` (About section +
footer) and swap in your real GitHub URL. LinkedIn is already linked.

---

## 📧 Contact form backend (Spring Boot)

The form on the site posts to `/api/contact`. `backend/` is a minimal,
ready-to-run Spring Boot service that emails submissions straight to you.

**Run it locally:**

```
cd backend
export MAIL_USERNAME=your.gmail@gmail.com
export MAIL_PASSWORD=your-16-char-app-password
./mvnw spring-boot:run
```

Generate a Gmail **App Password** at
https://myaccount.google.com/apppasswords — your normal Gmail password
won't work with SMTP.

This starts the API on `http://localhost:8080`. If you're testing the
frontend from a different origin during development, update
`CONTACT_ENDPOINT` in `js/script.js` to `http://localhost:8080/api/contact`.

**Deploying:** any host that runs a Java 17 app works (Render, Railway, a
VPS, etc.).

1. Set `MAIL_USERNAME` and `MAIL_PASSWORD` as environment variables on that host.
2. Update `CONTACT_ENDPOINT` in `js/script.js` to your deployed backend's URL.
3. Tighten `@CrossOrigin` in `ContactController.java` from `*` to your real domain.

---

## 🛠️ Tech stack

**Frontend:** HTML5, CSS3, vanilla JavaScript
**Backend:** Java, Spring Boot, Spring Mail
**Skills:** Java, SQL, HTML, CSS, JavaScript, React.js, Spring Boot, FastAPI, AWS, Docker, Git

---

## 📄 License

© 2026 Kashish Sharma. All rights reserved.
