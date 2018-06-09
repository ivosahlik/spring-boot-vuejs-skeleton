import Hello from './components/Hello'
import Service from './components/Service'

export const routes = [
  {path: '/', name: 'helloLink', component: Hello},
  {path: '/callservice', name: 'serviceLink', component: Service},
  {path: '*', redirect: '/'}
]
