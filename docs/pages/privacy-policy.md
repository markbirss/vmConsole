---
layout: page
title: Privacy Policy
permalink: /privacy-policy
---

This privacy policy describes what kind of data can be collected and
sent to us or third-parties and why, such as when you:

- Download and use the vmConsole application.
- Interacting with our online services within the application.
- Interacting with third-party online services within the application.
- Visiting our website.

Additionally we explain here how privacy-sensitive access permissions
are used by our application.

## vmConsole application

vmConsole does not collect and share any kind of personal data. The
permissions requested within the application are used only to make
it function properly or enable additional features.

- Internet permission (`android.permission.INTERNET`)

  Used to enable Internet access within the vmConsole virtual machine.
  Internet access is used exclusively on behalf of user in order to
  download or transfer content from third-party services. For example
  the Internet access is necessary to install packages from a remote
  repository.

- Storage permission (`android.permission.WRITE_EXTERNAL_STORAGE`)

  Used to let user access his files outside of the vmConsole virtual
  machine. This permission is optional and is disabled by default.
  On Android OS version 10 and higher, access scope is limited only
  to media files ([scoped storage](https://source.android.com/devices/storage/scoped)).

## Our website

vmConsole official web site is running on [GitHub Pages](https://pages.github.com/)
service. GitHub collects the IP addresses of visitors and stores
them for security purposes.

You may want to view [GitHub Privacy Policy](https://docs.github.com/en/site-policy/privacy-policies/github-privacy-statement).

## Third party services

vmConsole uses package repository server provided by the [Alpine Linux](https://alpinelinux.org/)
project for downloading and installing software packages using
a package manager `apk`. This service as well as the whole Alpine
Linux project are not affiliated with vmConsole in any way. User
IP address could be recorded statistics or security purposes
whenever a package or metadata archive was downloaded.

vmConsole acts only as environment for installing and running
other software made by third parties. Some programs may collect
extended set of personal data, including but not limited to email
addresses, phone numbers, files, tracked behavior. User must
consult the privacy policy and license agreement of program they
want to run in vmConsole and share their personal data with.
