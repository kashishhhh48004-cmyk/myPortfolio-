# Kashish Sharma — Portfolio

## Structure

```
portfolio/
├── index.html
├── css/style.css
├── js/script.js
├── assets/
│   ├── images/         ← your profile photo goes here
│   └── certs/           ← your certificate images go here
└── backend/              ← Spring Boot service for the contact form
```

## Replace your profile photo

Put your photo at `assets/images/profile.jpg`. Nothing else needs to change —
the page automatically falls back to a placeholder icon if that file isn't
there yet, so you can preview the site before you have a real photo.

## Replace certificate images

Add your three certificate images to `assets/certs/` using these exact names
(or open `index.html` and change the `src` values under the Certifications
section to whatever filenames you use):

- `assets/certs/ai-fluency.jpg` — AI Fluency (Anthropic)
- `assets/certs/java-scaler.jpg` — Java (Scaler)
- `assets/certs/sql-oracle.jpg` — SQL (Oracle)

## Add your social links

In `index.html`, search for `href="#"` (there are two spots — one in the
About section, one in the footer) and swap in your real GitHub/LinkedIn URLs.

## Viewing the site

The frontend is plain HTML/CSS/JS — no build step. Open `index.html` in a
browser, or serve the folder with any static server:

```
npx serve .
```

## Contact form backend (Spring Boot)

The form posts to `/api/contact`. The `backend/` folder is a minimal,
ready-to-run Spring Boot service that emails submissions to you.

**Run it locally:**

```
cd backend
export MAIL_USERNAME=your.gmail@gmail.com
export MAIL_PASSWORD=your-16-char-app-password
./mvnw spring-boot:run
```

(Generate a Gmail "App Password" at
https://myaccount.google.com/apppasswords — a regular Gmail password won't
work with SMTP.)

This starts the API on `http://localhost:8080`. If you're testing the
frontend from a different origin (e.g. `file://` or a different port), you
may need to point `CONTACT_ENDPOINT` in `js/script.js` at
`http://localhost:8080/api/contact` during local development.

**Deploying:** any host that runs a Java 17 app works (Render, Railway, a VPS,
etc.). Set `MAIL_USERNAME` and `MAIL_PASSWORD` as environment variables on
that host, and update `CONTACT_ENDPOINT` in `js/script.js` to your deployed
backend's URL. Before going live, also tighten the `@CrossOrigin` value in
`ContactController.java` from `*` to your actual site's domain.
