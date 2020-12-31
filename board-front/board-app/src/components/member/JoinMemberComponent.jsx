import React, { Component } from 'react';
import MemberService from '../../service/MemberService';
import ValidationUtil from '../../utils/ValidationUtil'

class JoinMemberComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            password: '',
            name: '',
            cp_number: '',
            phone_number: '',
            country: '',
            postal_code: '',
            address_1: '',
            address_2: '',
            address_3: '',
            address_4: '',
            sex: 0,
            birthday: '',
            nickname: '',
        }

    }

    changeIdHandler = (e) => {
        this.setState({id: e.target.value});
    }

    changePasswordHandler = (e) => {
        this.setState({password: e.target.value});
    }

    changeNameHandler = (e) => {
        this.setState({name: e.target.value});
    }

    changeCpNumber = (e) => {
        this.setState({cp_number: e.target.value});
    }

    changePhoneNumberHandler = (e) => {
        this.setState({phone_number: e.target.value});
    }

    changeCountryHandler = (e) => {
        this.setState({country: e.target.value});
    }

    changePostalCodeHandler = (e) => {
        this.setState({postal_code: e.target.value});
    }

    changeAddress1Handler = (e) => {
        this.setState({address_1: e.target.value});
    }

    changeAddress2Handler = (e) => {
        this.setState({address_2: e.target.value});
    }

    changeAddress3Handler = (e) => {
        this.setState({address_3: e.target.value});
    }

    changeAddress4Handler = (e) => {
        this.setState({address_4: e.target.value});
    }

    changeSexHandler = (e) => {
        this.setState({sex: e.target.value});
    }

    changeBirthdayHandler = (e) => {
        this.setState({birthday: e.target.value});
    }

    changeNicknameHandler = (e) => {
        this.setState({nickname: e.target.value});
    }

    joinMember = (e) => {
        e.preventDefault();
        let member = {
            id: this.state.id,
            password: this.state.password,
            name: this.state.name,
            cp_number: this.state.cp_number,
            phone_number: this.state.phone_number,
            country: this.state.country,
            postal_code: this.state.postal_code,
            address_1: this.state.address_1,
            address_2: this.state.address_2,
            address_3: this.state.address_3,
            address_4: this.state.address_4,
            sex: this.state.sex,
            birthday: this.state.birthday,
            nickname: this.state.nickname
        };
        console.log("member => "+ JSON.stringify(member));

        if (!this.validationCheck()) {
            return;
        }

        MemberService.getOneMemberFromUserId(member.id).then(res => {
            console.log("id check => "+ JSON.stringify(res));
            console.log("type? "+typeof(res.data));
            let json = JSON.stringify(res.data);
            if (json == 'true') {
                alert("이미 가입된 ID입니다.");

            } else {
                MemberService.createMember(member).then(res => {
                    this.props.history.push('/board');
                });
            }
        });
    }

    validationCheck() {
        if (!ValidationUtil.checkMail(this.state.id)){
            alert("ID 입력 에러 이메일 형식으로 입력해주세요")
            return false;
        }

        if (!ValidationUtil.checkPWD(this.state.password)){
            alert("Password 입력 에러 영어와 숫자를 조합한 6~20문자를 입력해주세요")
            return false;
        }

        if (!ValidationUtil.checkPhone(this.state.cp_number)){
            alert("대표전화번호 입력 에러 - 없이 숫자로만 입력해주세요")
            return false;
        }

        if (this.state.phone_number !== '') {
            if (!ValidationUtil.checkPhone(this.state.phone_number)){
                alert("예비전화번호 입력 에러 - 없이 숫자로만 입력해주세요")
                return false;
            }
        }

        return true;
    }

    render() {
        return (
<div>
    <div id="create-user" className="content" role="main">
        <h3 className="content-header">회원가입</h3>
        <div className="col-md-6 main-block-left">
            <div className="panel panel-default">
            <div className="panel-heading">
                <h5 className="panel-header">이메일로 가입하기</h5>
            </div>
            <form >
                    <input type="text" name="id" className="form-control input-sm"
                     required="" placeholder="아이디" value={this.state.id} onChange={this.changeIdHandler}/>
                    <input type="password" name="password" className="form-control input-sm"
                     required="" placeholder="비밀번호" value={this.state.password} onChange={this.changePasswordHandler}/>
                    <input type="text" name="name" className="form-control input-sm"
                     required="" placeholder="이름" value={this.state.name} onChange={this.changeNameHandler}/>
                    <input type="text" name="cpNnumber" className="form-control input-sm"
                     required="" placeholder="휴대전화번호" value={this.state.cp_number} onChange={this.changeCpNumber}/>
                    <input type="text" name="phoneNumber" className="form-control input-sm"
                     required="" placeholder="전화번호" value={this.state.phone_number} onChange={this.changePhoneNumberHandler}/>
                    <input type="text" name="country" className="form-control input-sm"
                     required="" placeholder="국적" value={this.state.country} onChange={this.changeCountryHandler}/>
                    <input type="text" name="postal_code" className="form-control input-sm"
                     required="" placeholder="우편번호" value={this.state.postal_code} onChange={this.changePostalCodeHandler}/>
                    <input type="text" name="address_1" className="form-control input-sm"
                     required="" placeholder="주소1" value={this.state.address_1} onChange={this.changeAddress1Handler}/>
                    <input type="text" name="address_2" className="form-control input-sm"
                     required="" placeholder="주소2" value={this.state.address_2} onChange={this.changeAddress2Handler}/>
                    <input type="text" name="address_3" className="form-control input-sm"
                     required="" placeholder="주소3" value={this.state.address_3} onChange={this.changeAddress3Handler}/>
                    <input type="text" name="address_4" className="form-control input-sm"
                     required="" placeholder="주소4" value={this.state.address_4} onChange={this.changeAddress4Handler}/>

                    <label>성별</label>
                    <select placeholder="sex" name="sex" className="form-control input-sm"
                      value={this.state.sex} onChange={this.changeSexHandler}>
                          <option value="0">선택안함</option>
                          <option value="1">남성</option>
                          <option value="2">여성</option>
                    </select>
                    <input type="text" name="birthday" className="form-control input-sm"
                     required="" placeholder="생년월일" value={this.state.birthday} onChange={this.changeBirthdayHandler}/>
                    <input type="text" name="nickname" className="form-control input-sm"
                     required="" placeholder="닉네임" value={this.state.nickname} onChange={this.changeNicknameHandler}/>

                    <button className="btn btn-primary btn-block" onClick={this.joinMember}>회원 가입</button>
                </form>
            </div>
        </div>
    </div>
</div>

        );
    }
}

export default JoinMemberComponent;