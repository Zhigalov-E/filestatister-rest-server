import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {

    constructor() {
        super();
        this.showFileStatistic = this.showFileStatistic.bind(this);
        this.hideFileStatistic = this.hideFileStatistic.bind(this);
        this.state = {files: []};
        this.isShowFileStat = {isShowFileStat: false};
    }

    componentDidMount() {
        fetch(`/api/files`)
            .then(result => result.json())
            .then(files => this.setState({files}))
            .catch((err) => {
                console.error('err', err);
            });
    }

    showFileStatistic(id) {
        this.setState({isShowFileStat: true});
        this.setState({fileId: id})
    }

    hideFileStatistic() {
        this.setState({isShowFileStat: false});
    }

    render() {
        return (
            <div>
                <span className="text-center ">
                    <h5>File Statistic</h5>
                </span>
                <div className="row">
                    <div className="col-md-5">
                        <FileList files={this.state.files}
                                  show={this.showFileStatistic}
                                  hide={this.hideFileStatistic}/>
                    </div>
                    <div className="col-md-5">
                        {  this.state.isShowFileStat &&
                        <FileStatistic fileId={this.state.fileId}/>
                        }
                    </div>
                </div>
            </div>

        );
    }
};

class FileList extends React.Component {
    render() {
        var files = this.props.files.map((file, i) =>
            <File key={i} file={file} show={this.props.show} hide={this.props.hide}/>
        );
        return (
            <table className="table table-bordered left">
                <thead>
                <tr>
                    <th className="col-md-1">ID</th>
                    <th className="col-md-2">FileName</th>
                    <th className="col-md-3">Path</th>
                    <th className="col-md-2"></th>
                </tr>
                </thead>
                <tbody>{files}</tbody>
            </table>
        );
    }
};

class File extends React.Component {
    constructor() {
        super();
        this.clickHandler = this.clickHandler.bind(this);
        this.state = {isShowDetail: false};
        this.state = {buttonName: "Show detail"};
    }

    clickHandler() {
        this.setState({isShowDetail: !this.state.isShowDetail});
        if (this.state.isShowDetail) {
            this.setState({buttonName: "Hide detail"});
            this.props.show(this.props.file.id);
        } else {
            this.setState({buttonName: "Show detail"});
            this.props.hide();
        }
    };

    render() {
        return (
            <tr key={this.props.file.id}>
                <td>{this.props.file.id}</td>
                <td>{this.props.file.name}</td>
                <td>{this.props.file.path}</td>
                <td>
                    <button className="btn btn-info"
                            onClick={this.clickHandler}>{this.state.buttonName}</button>
                </td>
            </tr>
        );
    }
};

class FileStatistic extends React.Component {
    constructor() {
        super();
        this.state = {fileStat: []};
    }

    componentDidMount() {
        fetch(`/api/files/` + this.props.fileId + '/stat')
            .then(result => result.json())
            .then(fileStat => this.setState({fileStat}))
            .catch((err) => {
                console.error('err', err);
            });

    }

    eachItem(item, i) {
        return (
            <tr key={item.id}>
                <th>{item.longestWord}</th>
                <th>{item.shortestWord}</th>
                <th>{item.linesLength}</th>
                <th>{item.averageWordLength}</th>
            </tr>
        );
    }

    render() {
        return (
            <table className="table table-bordered right">
                <thead>
                <tr>
                    <th>LongestWord</th>
                    <th>ShortestWord</th>
                    <th>LinesLength</th>
                    <th>AverageWordLength</th>
                </tr>
                </thead>
                <tbody>
                {this.state.fileStat.map(this.eachItem)}
                </tbody>
            </table>
        );
    }
};


ReactDOM.render(<App/>,
    document.getElementById('react')
);