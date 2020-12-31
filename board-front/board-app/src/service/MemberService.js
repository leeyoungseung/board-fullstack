import axios from 'axios';

const MEMBER_API_BASE_URL = "http://localhost:8080/api/member";

class MemberService {

    createMember(member) {
        return axios.post(MEMBER_API_BASE_URL, member);
    }

    getOneMemberFromUserId(id) {
        return axios.get(MEMBER_API_BASE_URL + "?id=" + id)
    }
}

export default new MemberService();